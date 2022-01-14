package com.grandtask.core.di

import com.grandtask.core.data.network.ApiHelper
import com.grandtask.core.data.network.RetrofitBuilder
import com.grandtask.core.data.repositories.RedditNewsRepository
import com.grandtask.core.usecases.RedditNewsUseCase

object ObjectsProvider {
    fun getUseCaseObject():RedditNewsUseCase{
        return RedditNewsUseCase(getRepositoryObject())
    }

    private fun getRepositoryObject():RedditNewsRepository{
        return RedditNewsRepository(getApiHelperObject())
    }

    private fun getApiHelperObject():ApiHelper{
        return ApiHelper(RetrofitBuilder.apiService)
    }
}