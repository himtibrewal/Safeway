package com.safeway.safeway.activity;

import static com.safeway.safeway.interfaces.CommenUtils.FromActivtiy;
import static com.safeway.safeway.interfaces.CommenUtils.Message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.gson.internal.LinkedTreeMap;
import com.safeway.safeway.models.request.ReqLogin;
import com.safeway.safeway.models.response.LoginResponseData;
import com.safeway.safeway.utility.AppPref;
import com.safeway.safeway.R;
import com.safeway.safeway.interfaces.ConfigURLs;
import com.safeway.safeway.models.response.ApiResponse;
import com.safeway.safeway.utility.APIUtil;


import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends BaseActivity {
    private AppPref pref;
    private ImageView backIv;

    private EditText etEmail;

    private EditText etPassword;

    private Button loginBtn;

    private Button signupBtn;

    private Button fPassBtn;

    private ConfigURLs configURLs;
    private String from, message, fromActivity, score, json;

    @Override
    public int getActivityLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initialize() {
        pref = AppPref.getInstance(this);
        configURLs = APIUtil.appConfig();
        if (getIntent().getExtras() != null) {
            from = getIntent().getExtras().getString("from");
            score = getIntent().getExtras().getString("score");
            json = getIntent().getExtras().getString("json");
            fromActivity = getIntent().getExtras().getString(FromActivtiy);
            message = getIntent().getExtras().getString(Message);
        }
    }

    @Override
    public void init(Bundle save) {
        loginBtn = findViewById(R.id.btn_login_login);
        signupBtn = findViewById(R.id.btn_login_signup);
        fPassBtn = findViewById(R.id.btn_login_f_pass);
        etEmail = findViewById(R.id.et_login_email);
        etPassword = findViewById(R.id.et_login_password);
        backIv = findViewById(R.id.iv_back);
        backIv.setOnClickListener(v -> sendToActivity(LoginActivity.class));
        // loginBtn.setOnClickListener(v -> sendToActivity(MainActivity.class));
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
        signupBtn.setOnClickListener(v -> sendToActivity(SignUpActivity.class));
        fPassBtn.setOnClickListener(v -> sendToActivity(ForgetPasswordActivity.class));
    }


    private void callLoginApi(ReqLogin reqLogin) {

        Call<ApiResponse> call = configURLs.getLogin(reqLogin);
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

                if (loginResponse.getResponseStatus().equals("200 OK")) {
                    Intent signinIntent = new Intent(LoginActivity.this, MainActivity.class);
                    pref.setIsLogin(true);
                    pref.setAccessToken(loginResponseData.getAccessToken());
                    pref.setRefToken(loginResponseData.getRefreshToken());
                    pref.setTokenType(loginResponseData.getTokenType());
                    pref.setUserId(loginResponseData.getId());
                    pref.setEmail(loginResponseData.getEmail());
                    pref.setMobile(loginResponseData.getMobile());
                    pref.setUserName(loginResponseData.getUserName());
                    signinIntent.putExtra("from", "SignInFrag");
//                    signinIntent.putExtra("name", loginResponseData.getName());
//                    signinIntent.putExtra("email", loginResponseData.getEmail());
//                    signinIntent.putExtra("image", loginResponseData.getImage());
                    startActivity(signinIntent);
                    //getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                    getActivity().finish();
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


    private void sendToActivity(Class<?> classs) {
        Intent intent = new Intent(LoginActivity.this, classs);
        startActivity(intent);
    }

    private void validate() {
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        if (email.length() < 1) {
            Toast.makeText(this, "please enter email", Toast.LENGTH_LONG).show();
        } else if (password.length() < 1) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_LONG).show();
        } else {
            ReqLogin reqLogin = new ReqLogin(email, password);
            callLoginApi(reqLogin);
        }
    }


}