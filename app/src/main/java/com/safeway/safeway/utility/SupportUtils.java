package com.safeway.safeway.utility;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;


import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Himanshu on 07/12/23
 */
public class SupportUtils {

    // Email validity check
    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    // contact Number Validity check
    public static boolean isValidContact(String contact) {
        if (contact != null && contact.length() > 9) {
            return true;
        }
        return false;
    }

    public static boolean isValidString(String text) {
        if (text != null && !text.trim().equalsIgnoreCase("")) {
            return true;
        }
        return false;
    }


    public static float dp2px(Resources resources, float dp) {
        final float scale = resources.getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }

    public static float sp2px(Resources resources, float sp) {
        final float scale = resources.getDisplayMetrics().scaledDensity;
        return sp * scale;
    }


    public static Bitmap decodeUri(Context c, Uri uri, final int requiredSize)
            throws FileNotFoundException {

        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(c.getContentResolver().openInputStream(uri), null, o);

        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;

        while (true) {
            if (width_tmp / 2 < requiredSize || height_tmp / 2 < requiredSize)
                break;
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(c.getContentResolver().openInputStream(uri), null, o2);

    }


//    public static void applyFontedTab(Activity activity, ViewPager viewPager, TabLayout tabLayout) {
//        for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
//            TextView tv = (TextView) activity.getLayoutInflater().inflate(R.layout.item_tab, null);
//            SpannableStringBuilder sBuilder = new SpannableStringBuilder();
//            sBuilder.append(viewPager.getAdapter().getPageTitle(i)); // Bold this
//            CalligraphyTypefaceSpan typefaceSpan = new CalligraphyTypefaceSpan(TypefaceUtils.load(activity.getAssets(), "fonts/Nunito-Bold.ttf"));
//            CalligraphyTypefaceSpan typefaceSpanREg = new CalligraphyTypefaceSpan(TypefaceUtils.load(activity.getAssets(), "fonts/Nunito-Regular.ttf"));
//            if (i == viewPager.getCurrentItem()) {
//                tv.setSelected(true);
//                sBuilder.setSpan(typefaceSpan, 0, sBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            } else {
//              //  sBuilder.setSpan(typefaceSpanREg, 0, sBuilder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//            tv.setText(sBuilder, TextView.BufferType.SPANNABLE);
//            tabLayout.getTabAt(i).setCustomView(tv);
//        }
//    }
}
