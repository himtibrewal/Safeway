package com.safeway.safeway.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.safeway.safeway.R;
import com.safeway.safeway.interfaces.ConfigURLs;
import com.safeway.safeway.utility.APIUtil;
import com.safeway.safeway.utility.AppPref;
import com.safeway.safeway.utility.CheckNetworkState;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;
    private ProgressBar progressBar;
    private AppPref appPref;
    private ConfigURLs configURLs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        appPref = AppPref.getInstance(this);
        configURLs = APIUtil.appConfig();
        imageView = (ImageView) findViewById(R.id.iv_icon);
        progressBar = (ProgressBar) findViewById(R.id.progress_circular);
        progressBar.setProgress(100);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.splash));
        imageView.setBackgroundColor(getResources().getColor(R.color.primary_color));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        }, 2000);

        PackageInfo info;
        try {
            info = getPackageManager().getPackageInfo("com.safeway", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hash key", something);
                System.out.println("hash key===>" + something);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
        if (new CheckNetworkState(this).isNetworkAvailable()) {
            Toast.makeText(this, "Network Available !!", Toast.LENGTH_LONG).show();
//            if (pref.isCallClass() == false)
//                callClassApi();
//            else {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        nextActivity();
//                    }
//                }, 1000);
//            }
//        } else {
//            if (pref.isCallClass() == true) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        nextActivity();
//                    }
//                }, 1000);
//            }else{
//                showMessage(iv_icon, getResources().getString(R.string.plz_check_internet), SplashActivity.this);
//            }
        }

    }


//    private void callClassApi() {
//
//        Call<ClassesResponse> call = configURLs.getClasses(pref.getUSER_ID());
//        call.enqueue(new Callback<ClassesResponse>() {
//            @Override
//            public void onResponse(Call<ClassesResponse> call, Response<ClassesResponse> response) {
//                ClassesResponse classesResponse = response.body();
//                pref.setIsCallClass(true);
//                classeseResponseDataItem = classesResponse.getResponseData();
//                if (!classesResponse.getResponseCode().equals(ResponseCodeFailure)) {
////                    init(classeseResponseDataItem);
//                    realmSetClassData(classesResponse.getResponseData());
//                    nextActivity();
//                } else {
//                    showMessage(iv_icon, classesResponse.getResponseMessage(), SplashActivity.this);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ClassesResponse> call, Throwable t) {
//                showMessage(iv_icon, t.getMessage(), SplashActivity.this);
//            }
//        });
//
//    }

//    public void showMessage(View view, String message, Activity activity) {
//        Snackbar snack = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
//        view = snack.getView();
//
//        view.setBackgroundColor(ContextCompat.getColor(activity, R.color.second_color));
//        TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
//        tv.setTextColor(Color.WHITE);
//        snack.show();
//    }

//    private void realmSetClassData(final List<ClassessResponseDataItem> list) {
//
//        try {
//            realm.executeTransaction(new Realm.Transaction() {
//                @Override
//                public void execute(Realm realm) {
//                    realm.insertOrUpdate(list);
//                }
//            });
//        } finally {
//            if (realm != null) {
//                realm.close();
//            }
//        }
////        realm.beginTransaction();
////        realm.insert(list);
////        realm.commitTransaction();
//    }

    private void nextActivity() {
        if (appPref.isLogin()) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
        }

//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        finish();
    }
}