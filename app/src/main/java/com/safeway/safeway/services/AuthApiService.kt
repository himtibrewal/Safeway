package com.safeway.safeway.services

import com.safeway.safeway.models.Auth
import com.safeway.safeway.models.response.ApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun login(
            @Body auth: Auth,
    ): Response<ApiResponse>

    @GET("auth/refresh")
    suspend fun refreshToken(
            @Header("Authorization") token: String,
    ): Response<ApiResponse>
}