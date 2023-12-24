package com.safeway.safeway.utility;

import com.safeway.safeway.interfaces.ConfigURLs;

/**
 * Created by Himanshu on 07/12/23.
 */

public class APIUtil {

    public APIUtil() {
    }
   // public static final String BASE_URL = "http://10.0.2.2:8080";
    public static final String BASE_URL = "http://192.168.29.6:8080/";
    // public static final String BASE_URL = "http://ec2-204-236-221-32.compute-1.amazonaws.com:8080/";

    public static ConfigURLs appConfig(){
        return AppConfig.getClient(BASE_URL).create(ConfigURLs.class);
    }
}
