package com.grandtask.core.data.network

import retrofit2.Retrofit

object RetrofitBuilder {
    private const val BASE_URL = "https://www.reddit.com/"
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
    }
    val apiService:ApiService = getRetrofit().create(ApiService::class.java)
}