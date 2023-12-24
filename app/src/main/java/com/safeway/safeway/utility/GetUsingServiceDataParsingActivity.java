package com.safeway.safeway.utility;

import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.safeway.safeway.interfaces.GetWebServiceData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Himanshu on 07/12/23
 */

public class GetUsingServiceDataParsingActivity implements Response.ErrorListener, Response.Listener<String> {
    private Context context;
    private String url;
    private int serviceCounter;
    private Map<String ,String > content;
    private boolean isShowProgress;
    private String responseData;
    private GetWebServiceData getWebServiceData;

    public GetUsingServiceDataParsingActivity(Context context,
                                              String url,
                                              int serviceCounter,
                                              Map<String ,String > content,
                                              boolean isShowProgress,
                                              GetWebServiceData getWebServiceData) {
        this.context=context;
        this.url=url;
        this.serviceCounter=serviceCounter;
        this.content=content;
        this.getWebServiceData=getWebServiceData;
        request();
    }

    private void request() {
        if (isShowProgress){
            showProgress();
        }
        StringRequest stringRequest=new StringRequest(Request.Method.POST,url,this,this){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params = content;
                return params;
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        if (isShowProgress) {
            //hide  dialog  here
            loader.dismiss();
        }
        String message = null;
        if (error instanceof NetworkError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (error instanceof ServerError) {
            message = "The server could not be found. Please try again after some time!!";
        } else if (error instanceof AuthFailureError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (error instanceof ParseError) {
            message = "Parsing error! Please try again after some time!!";
        } else if (error instanceof TimeoutError) {
            message = "Connection TimeOut! Please check your internet connection.";
        }

        responseData = message;
        getWebServiceData.getWebServiceResponse(responseData, serviceCounter);

    }

    @Override
    public void onResponse(String response) {
        if (isShowProgress) {
            //hide  dialog  here
            loader.dismiss();
        }
        responseData = response;
        getWebServiceData.getWebServiceResponse(responseData, serviceCounter);
    }

    Dialog loader;
    ProgressDialog loader_wheel;
//    ProgressWheel loader_wheel;

    private void showProgress() {
        // TODO Auto-generated method stub
        loader = new Dialog(context);
        loader.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        loader.setContentView(R.layout.dialog_progress);
//        loader_wheel = (ProgressDialog) loader.findViewById(R.id.progress_wheel);
//        loader_wheel.setCircleRadius(50);
        loader.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        loader.setCancelable(false);
        loader.show();
    }
}
