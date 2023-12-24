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

import androidx.appcompat.app.AppCompatActivity;

import com.safeway.safeway.R;
import com.safeway.safeway.interfaces.ConfigURLs;
import com.safeway.safeway.models.request.AddVehicle;
import com.safeway.safeway.models.request.ReqForget;
import com.safeway.safeway.models.response.ApiResponse;
import com.safeway.safeway.utility.APIUtil;
import com.safeway.safeway.utility.AppPref;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;


public class AddVehicleActivity extends BaseActivity {

    private ImageView backIv;

    private ConfigURLs configURLs;

    private AppPref pref;

    ImageView ivImage;

    EditText etType, etBrand, etModel, etRegistration;

    Button btnSubmit;

    @Override
    public int getActivityLayout() {
        return R.layout.activity_vehicle;
    }

    @Override
    public void initialize() {
        pref = AppPref.getInstance(this);
        configURLs = APIUtil.appConfig();
    }

    @Override
    public void init(Bundle save) {
        ivImage = findViewById(R.id.iv_vehicle_image);
        etType = findViewById(R.id.et_vehicle_type);
        etBrand = findViewById(R.id.et_vehicle_model);
        etModel = findViewById(R.id.et_vehicle_type);
        etRegistration = findViewById(R.id.et_vehicle_rno);
        // backIv = findViewById(R.id.iv_back);
        btnSubmit = findViewById(R.id.btn_vehicle_submit);
        //backIv.setOnClickListener(v -> sendToActivity(MainActivity.class));

        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Image Not Required !", Toast.LENGTH_LONG).show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

    }

    private void sendToActivity(Class<?> classs) {
        Intent intent = new Intent(AddVehicleActivity.this, classs);
        startActivity(intent);
    }

    private void validate() {
        String type = etType.getText().toString();
        String brand = etBrand.getText().toString();
        String model = etModel.getText().toString();
        String registration = etRegistration.getText().toString();

        if (type.length() < 1) {
            Toast.makeText(this, "please enter type", Toast.LENGTH_LONG).show();
        } else if (brand.length() < 1) {
            Toast.makeText(this, "please enter brand", Toast.LENGTH_LONG).show();
        } else if (model.length() < 1) {
            Toast.makeText(this, "please enter model", Toast.LENGTH_LONG).show();
        } else if (registration.length() < 1) {
            Toast.makeText(this, "please enter Registration Number", Toast.LENGTH_LONG).show();
        } else {
            AddVehicle addVehicle = new AddVehicle(type, brand, model, registration);
            addVehicle.setImage("");
            callForgetApi(addVehicle);
        }
    }


    private void callForgetApi(AddVehicle addVehicle) {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Accept", "application/json");
        headerMap.put("Content-Type", "application/json");
        headerMap.put("Authorization", pref.getTokenType() + " " + pref.getAccessToken());
        headerMap.put("refresh-token", pref.getRefToken());
        Call<ApiResponse> call = configURLs.userVehicle(headerMap, addVehicle);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, retrofit2.Response<ApiResponse> response) {
                ApiResponse forgetResponse = response.body();
                if (forgetResponse.getResponseStatus().equals("201 CREATED")) {
                    Intent vehicleAddIntent = new Intent(AddVehicleActivity.this, MainActivity.class);
                    pref.setVehicleCount(pref.getVehicleCount() + 1);
                    vehicleAddIntent.putExtra("from", "AddVehicleActivity");
                    startActivity(vehicleAddIntent);
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