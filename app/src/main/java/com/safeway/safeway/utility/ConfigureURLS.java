package com.safeway.safeway.utility;

import android.content.Context;

/**
 * Created by Himanshu on 28/11/17.
 */

public class ConfigureURLS {
    public static Context context;

    public ConfigureURLS(Context context) {
        this.context=context;
    }

    public static String BaseUrl="http://ec2-204-236-221-32.compute-1.amazonaws.com";

    public static String URL_LOGIN=BaseUrl+"/auth/login";
//    public static String URL_REGISTER=BaseUrl+"registerStudent";
//    public static String URL_GET_CLASS=BaseUrl+"getClasses";
//    public static String URL_GET_BOARDS=BaseUrl+"getBoards";
//    public static String URL_GET_SUBJECTS=BaseUrl+"getSubjects";
//    public static String URL_GET_CHAPTERS=BaseUrl+"getChapters";
//    public static String URL_EDIT_PROFILE_IMAGE=BaseUrl+"editProfile";
//
//    public static String URL_Report=BaseUrl+"addFlagData";
//    public static String URL_ChangePassword=BaseUrl+"changePassword";
}
