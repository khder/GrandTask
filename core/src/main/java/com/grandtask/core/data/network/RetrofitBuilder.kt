package com.grandtask.core.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "https://www.reddit.com/"
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
    }
    val apiService:ApiService = getRetrofit().create(ApiService::class.java)
}