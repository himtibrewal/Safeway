package com.safeway.safeway.utility;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Himanshu on 03/12/23.
 */

public class AppPref {
    private static AppPref instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sEditor;
    private String SG_SHARED_PREFERENCE = "shared_preference";
    private static final String PREF_DEVICE_ID = "device_Id";
    private static final String PREF_USER_ID = "userId";
    private static final String PREF_USER_NAME = "user_name";
    private static final String PREF_EMAIL = "email";
    private static final String PREF_MOBILE = "mobile";
    private static final String PREF_ACCESS_TOKEN = "access_token";
    private static final String PREF_REFRESH_TOKEN = "refresh_token";
    private static final String PREF_TOKEN_TYPE = "token_type";
    private static final String PREF_TOKEN_EXPIRE_TIME = "expire_time";
    private static final String PREF_IS_LOGIN = "is_login";
    private static final String PREF_ADDED_VEHICLE = "vehicle_count";


    private AppPref(Context context) {
        sharedPreferences = context.getSharedPreferences(SG_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        sEditor = sharedPreferences.edit();
    }

    public static AppPref getInstance(Context context) {
        if (instance == null) instance = new AppPref(context);
        return instance;
    }

    public void registerPre(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unRegister(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }


    public boolean isLogin() {
        return sharedPreferences.getBoolean(PREF_IS_LOGIN, false);
    }

    public void setIsLogin(boolean isLogin) {
        sEditor.putBoolean(PREF_IS_LOGIN, isLogin);
        sEditor.commit();
    }

    public String getRefToken() {
        return sharedPreferences.getString(PREF_REFRESH_TOKEN, "");
    }

    public void setRefToken(String token) {
        sEditor.putString(PREF_REFRESH_TOKEN, token);
        sEditor.commit();
    }

    public String getAccessToken() {
        return sharedPreferences.getString(PREF_ACCESS_TOKEN, "");
    }

    public void setAccessToken(String accessToken) {
        sEditor.putString(PREF_ACCESS_TOKEN, accessToken);
        sEditor.commit();
    }

    public String getTokenType() {
        return sharedPreferences.getString(PREF_TOKEN_TYPE, "");
    }

    public void setTokenType(String tokenType) {
        sEditor.putString(PREF_TOKEN_TYPE, tokenType);
        sEditor.commit();
    }

    public String getTokenExpireTime() {
        return sharedPreferences.getString(PREF_TOKEN_EXPIRE_TIME, "");
    }

    public void setTokenExpireTime(String tokenExpireTime) {
        sEditor.putString(PREF_TOKEN_EXPIRE_TIME, tokenExpireTime);
        sEditor.commit();
    }


    public String getEmail() {
        return sharedPreferences.getString(PREF_EMAIL, "");
    }

    public void setEmail(String email) {
        sEditor.putString(PREF_EMAIL, email);
        sEditor.commit();
    }

    public String getMobile() {
        return sharedPreferences.getString(PREF_MOBILE, "");
    }

    public void setMobile(String mobile) {
        sEditor.putString(PREF_MOBILE, mobile);
        sEditor.commit();
    }

    public String getUserName() {
        return sharedPreferences.getString(PREF_USER_NAME, "");
    }

    public void setUserName(String username) {
        sEditor.putString(PREF_USER_NAME, username);
        sEditor.commit();
    }


    public String getUserId() {
        return sharedPreferences.getString(PREF_USER_ID, "");
    }

    public void setUserId(String userId) {
        sEditor.putString(PREF_USER_ID, userId);
        sEditor.commit();
    }

    public String getDeviceId() {
        return sharedPreferences.getString(PREF_DEVICE_ID, "");
    }

    public void setDeviceId(String userId) {
        sEditor.putString(PREF_DEVICE_ID, userId);
        sEditor.commit();
    }

    public Integer getVehicleCount() {
        return sharedPreferences.getInt(PREF_ADDED_VEHICLE, 0);
    }

    public void setVehicleCount(int vehicleCount) {
        sEditor.putInt(PREF_ADDED_VEHICLE, vehicleCount);
        sEditor.commit();
    }

}
