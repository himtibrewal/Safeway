package com.safeway.safeway.utility;

import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Created by Himanshu on 07/12/23
 */

public class Validations {

    public enum ValidConstants {
        NOTHING_ENTERED, SUCCESS
    }


    public static boolean isValidName(String name) {
        if (name != null) {
            if (name.trim().length() > 2) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public static boolean isValidMobileNumbers(String mobileNumber) {
        boolean isValidMobileNumber = false;

        if (!Pattern.matches("[a-zA-Z]", mobileNumber)) {

            //mobile number doesn't contains characters
            if (mobileNumber.length() == 10) {
                isValidMobileNumber = true;
            } else {
                isValidMobileNumber = false;
            }

        } else {
            //mobile number contains characters
            isValidMobileNumber = false;
        }
        return isValidMobileNumber;
    }

    public static boolean isValidEmailId(String emailId) {

        if (emailId != null) {
            return Patterns.EMAIL_ADDRESS.matcher(emailId).matches();
        } else {
            return false;
        }
    }

    public static boolean isValidPassword(String password) {
        if (password != null) {
            if (password.trim().length() > 7) {
                //password should be greater than seven
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
