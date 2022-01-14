package com.grandtask.core.data.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("r/kotlin/.json")
    fun getArticles(): Call<String>
}