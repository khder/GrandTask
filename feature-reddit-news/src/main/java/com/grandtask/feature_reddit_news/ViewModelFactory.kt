package com.grandtask.feature_reddit_news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grandtask.core.data.network.ApiHelper
import com.grandtask.core.usecases.RedditNewsUseCase

class ViewModelFactory(private val useCase: RedditNewsUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RedditNewsViewModel::class.java)) {
            return RedditNewsViewModel(useCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}