package com.grandtask.core.data.network

class ApiHelper(private val apiService: ApiService) {
     fun getArticles() = apiService.getArticles()
}