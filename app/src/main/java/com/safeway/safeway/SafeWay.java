package com.safeway.safeway;


import android.app.Application;
import android.content.Context;
import android.provider.Settings;


public class SafeWay extends Application {
    private static SafeWay safeWay;
    public static String device_id;
    public static String video_url = "";

    public static synchronized SafeWay getInstance() {
        if (safeWay== null) {
            synchronized(SafeWay.class) {
                if (safeWay == null)
                    safeWay = new SafeWay();

            }
        }
        return safeWay;
    }

    private SafeWay()
    {
        // Constructor hidden because this is a singleton
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //Realm Configuration
//        Realm.init(this);
//        RealmConfiguration config = new RealmConfiguration
//                .Builder()
//                .deleteRealmIfMigrationNeeded()
//                .build();
//        Realm.setDefaultConfiguration(config);

        //fabric
//        Fabric.with(this, new Crashlytics());
        safeWay = this;
//        MultiDex.install(this);
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                //.setDefaultFontPath("fonts/Nunito-Light.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        );
        device_id = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

    }

    public Context getApplicationContext() {
        return super.getApplicationContext();
    }


    public static String getDeviceID() {
        return device_id;
    }

    public static CharSequence trim(CharSequence s, int start, int end) {
        while (start < end && Character.isWhitespace(s.charAt(start))) {
            start++;
        }

        while (end > start && Character.isWhitespace(s.charAt(end - 1))) {
            end--;
        }

        return s.subSequence(start, end);
    }


}

