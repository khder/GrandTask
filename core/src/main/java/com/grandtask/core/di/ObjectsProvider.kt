package com.grandtask.core.di

import android.content.Context
import com.grandtask.core.data.database.AppDatabase
import com.grandtask.core.data.database.ArticleDao
import com.grandtask.core.data.network.ApiHelper
import com.grandtask.core.data.network.RetrofitBuilder
import com.grandtask.core.data.repositories.RedditNewsRepository
import com.grandtask.core.usecases.RedditNewsUseCase

object ObjectsProvider {
    fun getUseCaseObject(appContext: Context):RedditNewsUseCase{
        return RedditNewsUseCase(getRepositoryObject(appContext))
    }

    private fun getRepositoryObject(appContext: Context):RedditNewsRepository{
        return RedditNewsRepository(getApiHelperObject(), getArticlesDao(appContext),appContext)
    }

    private fun getApiHelperObject():ApiHelper{
        return ApiHelper(RetrofitBuilder.apiService)
    }

    private fun getArticlesDao(appContext: Context):ArticleDao{
        return AppDatabase.getDatabase(appContext).articleDao()
    }
}