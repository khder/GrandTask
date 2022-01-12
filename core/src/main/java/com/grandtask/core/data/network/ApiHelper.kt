package com.grandtask.core.data.network

class ApiHelper(private val apiService: ApiService) {
    suspend fun getArticles() = apiService.getArticles()
}