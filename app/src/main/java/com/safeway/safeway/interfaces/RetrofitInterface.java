package com.safeway.safeway.interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Himanshu on 07/12/23.
 **/

public interface RetrofitInterface {

    @GET
    @Streaming
    Call<ResponseBody> downloadFile(@Url String url);
}
