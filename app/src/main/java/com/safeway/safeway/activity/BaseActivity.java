package com.safeway.safeway.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.safeway.safeway.R;

public abstract class BaseActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    // MyProgressDialogFragment myDialogFragment;
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }


    @Override
    public void onCreate(Bundle save) {
        super.onCreate(save);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        setContentView(getActivityLayout());
        //  setTitle(readString(getActivityTitle()));
        fragmentManager = getFragmentManager();
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialize();
        init(save);
    }

    @Override
    public void onStart() {
        super.onStart();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void bAlert(String title, String message) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle(title);
        adb.setMessage(message);
        adb.setPositiveButton(getResources().getString(R.string.app_name), null);
        adb.show();
    }

    public String readString(int string) {
        return getResources().getString(string);
    }

    public String getDeviceModel() {
        return Build.MANUFACTURER;
    }

    public abstract int getActivityLayout();

    public abstract void initialize();

    public abstract void init(Bundle save);


    @Override
    public void onBackPressed() {
        hideKeyBoard();
        super.onBackPressed();
//        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    public void hideKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void sendToThisActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    public void sendToThisActivity(Class activity, int flag) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(flag);
        startActivity(intent);
    }

    public void sendToThisActivity(Class activity, String s[]) {
        Intent intent = new Intent(this, activity);
        for (int i = 0; i < s.length; i++) {
            String p[] = s[i].split(";");
            intent.putExtra(p[0], p[1]);
        }
        startActivity(intent);
    }

    public void sendToThisActivity(Class activity, String s[], int flag) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(flag);
        for (int i = 0; i < s.length; i++) {
            String p[] = s[i].split(";");
            intent.putExtra(p[0], p[1]);
        }
        startActivity(intent);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        // super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

//    public void showMessage(View view, String message, Activity activity) {
////        Typeface font = Typeface.createFromAsset(activity.getAssets(), "fonts/UBUNTU-MEDIUM.TTF");
//        Snackbar snack = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
//        view = snack.getView();
//
//        view.setBackgroundColor(ContextCompat.getColor(activity, R.color.colorPrimary));
//        TextView tv = (TextView) view.findViewById(android.support.design.R.id.snackbar_text);
//        tv.setTextColor(Color.WHITE);
////        tv.setTypeface(font);
//        snack.show();
//    }

//    public void ShowDialog() {
//        myDialogFragment = new MyProgressDialogFragment();
//        myDialogFragment.show(fragmentManager, "loader");
//        myDialogFragment.setCancelable(false);
//
//    }
//
//    public void DismissDialog() {
//        myDialogFragment.dismiss();
//    }
//
//
//    public void serverAlertDialog(String message) {
//        android.app.FragmentManager fm = getFragmentManager();
//        ConnectivityDialogFragment connectivityDialogFragment = ConnectivityDialogFragment.getInstance(message);
//        connectivityDialogFragment.show(fm, "dialog");
//    }
}