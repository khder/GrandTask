package com.grandtask.core.data.network

import com.grandtask.core.data.models.Article
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("r/kotlin/.json")
    suspend fun getArticles(): Call<ResponseBody>
}