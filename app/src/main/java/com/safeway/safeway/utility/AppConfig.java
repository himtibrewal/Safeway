package com.safeway.safeway.utility;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by esec-sruthi on 20/1/18.
 */

public class AppConfig {
    private static Retrofit retrofit=null;

    public static Retrofit getClient(String url){
        if (retrofit == null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

