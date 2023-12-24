package com.safeway.safeway.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.gson.internal.LinkedTreeMap;
import com.safeway.safeway.R;
import com.safeway.safeway.interfaces.ConfigURLs;
import com.safeway.safeway.models.request.ReqRegister;
import com.safeway.safeway.models.response.ApiResponse;
import com.safeway.safeway.models.response.LoginResponseData;
import com.safeway.safeway.utility.APIUtil;
import com.safeway.safeway.utility.AppPref;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;


public class SignUpActivity extends BaseActivity {

    private AppPref pref;

    private ImageView backIv;

    private EditText etName;

    private EditText etEmail;

    private EditText etMobile;

    private EditText etPassword;

    private Button loginBtn;

    private Button signupBtn;

    private ConfigURLs configURLs;

    @Override
    public int getActivityLayout() {
        return R.layout.activity_signup;
    }

    @Override
    public void initialize() {
        pref = AppPref.getInstance(this);
        configURLs = APIUtil.appConfig();
//        if (getIntent().getExtras() != null) {
//            from = getIntent().getExtras().getString("from");
//            score = getIntent().getExtras().getString("score");
//            json = getIntent().getExtras().getString("json");
//            fromActivity = getIntent().getExtras().getString(FromActivtiy);
//            message = getIntent().getExtras().getString(Message);
//        }
    }

    @Override
    public void init(Bundle save) {
        etName = findViewById(R.id.et_signup_name);
        etEmail = findViewById(R.id.et_signup_email);
        etMobile = findViewById(R.id.et_signup_mobile);
        etPassword = findViewById(R.id.et_signup_password);
        signupBtn = findViewById(R.id.btn_signup_signup);
        loginBtn = findViewById(R.id.btn_signup_login);
        backIv = findViewById(R.id.iv_back);

        backIv.setOnClickListener(v -> sendToActivity(LoginActivity.class));

        loginBtn.setOnClickListener(v -> sendToActivity(LoginActivity.class));

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

    }


    private void sendToActivity(Class<?> classs) {
        Intent intent = new Intent(SignUpActivity.this, classs);
        startActivity(intent);
    }

    private void validate() {
        String name = etName.getText().toString();
        String mobile = etMobile.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.length() < 1) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_LONG).show();
        } else if (name.length() < 1) {
            Toast.makeText(this, "please enter name", Toast.LENGTH_LONG).show();
        } else if (mobile.length() < 1) {
            Toast.makeText(this, "please enter Mobile", Toast.LENGTH_LONG).show();
        } else if (password.length() < 1) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_LONG).show();
        } else {
            ReqRegister reqRegister = new ReqRegister(name, email, mobile, password);
            callRegisterApi(reqRegister);
        }
    }


    private void callRegisterApi(ReqRegister reqRegister) {

        Call<ApiResponse> call = configURLs.registerUser(reqRegister);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, retrofit2.Response<ApiResponse> response) {
                ApiResponse loginResponse = response.body();
                Map<String, Object> res = (LinkedTreeMap) loginResponse.getResponseData();
                LoginResponseData loginResponseData = new LoginResponseData();
                loginResponseData.setId(res.get("id").toString());
                loginResponseData.setTokenType(res.get("email").toString());
                loginResponseData.setUserName(res.get("username").toString());
                loginResponseData.setMobile(res.get("mobile").toString());
                loginResponseData.setAccessToken(res.get("access_token").toString());
                loginResponseData.setRefreshToken(res.get("refresh_token").toString());
                loginResponseData.setTokenType(res.get("token_type").toString());

                if (loginResponse.getResponseStatus().equals("201 CREATED")) {
                    Intent signinIntent = new Intent(SignUpActivity.this, MainActivity.class);
                    pref.setIsLogin(true);
                    pref.setAccessToken(loginResponseData.getAccessToken());
                    pref.setRefToken(loginResponseData.getRefreshToken());
                    pref.setTokenType(loginResponseData.getTokenType());
                    pref.setUserId(loginResponseData.getId());
                    pref.setEmail(loginResponseData.getEmail());
                    pref.setMobile(loginResponseData.getMobile());
                    pref.setUserName(loginResponseData.getUserName());
                    signinIntent.putExtra("from", "SignUpActivity");
                    startActivity(signinIntent);
                } else {
                    toastMessage(loginResponse.getResponseMessage());
                }

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                toastMessage(t.getMessage());
            }
        });
    }

}