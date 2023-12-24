//package com.safeway.safeway;
//
//import com.safeway.safeway.models.Auth;
//import com.safeway.safeway.models.response.LoginResponse;
//
//import retrofit2.Call;
//import retrofit2.http.Body;
//import retrofit2.http.Field;
//import retrofit2.http.FormUrlEncoded;
//import retrofit2.http.GET;
//import retrofit2.http.POST;
//import retrofit2.http.Query;
//
//public interface APIInterface {
//
//    @GET("/auth/login")
//    Call<LoginResponse> loginUser();
//
//    @POST("/auth/login")
//    Call<LoginResponse> loginUser(@Body Auth auth);
//
////    @GET("/api/users?")
////    Call<UserList> doGetUserList(@Query("page") String page);
////
////    @FormUrlEncoded
////    @POST("/api/users?")
////    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
//}