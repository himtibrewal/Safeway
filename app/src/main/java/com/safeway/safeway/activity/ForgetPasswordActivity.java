package com.safeway.safeway.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.safeway.safeway.R;
import com.safeway.safeway.interfaces.ConfigURLs;
import com.safeway.safeway.models.request.ReqForget;
import com.safeway.safeway.models.response.ApiResponse;
import com.safeway.safeway.utility.APIUtil;
import com.safeway.safeway.utility.AppPref;

import retrofit2.Call;
import retrofit2.Callback;


public class ForgetPasswordActivity extends BaseActivity {

    private AppPref pref;

    private ConfigURLs configURLs;

    private ImageView backIv;

    private EditText etEmail;

    private Button forgetBtn;

    @Override
    public int getActivityLayout() {
        return R.layout.activity_forget_password;
    }

    @Override
    public void initialize() {
        pref = AppPref.getInstance(this);
        configURLs = APIUtil.appConfig();
    }

    @Override
    public void init(Bundle save) {
        etEmail = findViewById(R.id.et_forget_email);
        forgetBtn = findViewById(R.id.btn_forget_forget);
        backIv = findViewById(R.id.iv_back);
        backIv.setOnClickListener(v -> sendToActivity(LoginActivity.class));

        forgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

    }


    private void sendToActivity(Class<?> classs) {
        Intent intent = new Intent(ForgetPasswordActivity.this, classs);
        startActivity(intent);
    }

    private void validate() {
        String email = etEmail.getText().toString();

        if (email.length() < 1) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_LONG).show();
        } else {
            ReqForget reqForget = new ReqForget(email);
            callForgetApi(reqForget);
        }
    }


    private void callForgetApi(ReqForget reqForget) {
        Call<ApiResponse> call = configURLs.forgetUser(reqForget);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, retrofit2.Response<ApiResponse> response) {
                ApiResponse forgetResponse = response.body();
                if (forgetResponse.getResponseStatus().equals("200 OK")) {
                    Intent signinIntent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                    pref.setIsLogin(false);
                    pref.setAccessToken("");
                    pref.setRefToken("");
                    pref.setTokenType("");
                    pref.setUserId("");
                    pref.setEmail("");
                    pref.setMobile("");
                    pref.setUserName("");
                    signinIntent.putExtra("from", "ForgetActivity");
                    startActivity(signinIntent);
                } else {
                    toastMessage(forgetResponse.getResponseMessage());
                }

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                toastMessage(t.getMessage());
            }
        });
    }
}