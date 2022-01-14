package com.grandtask.feature_reddit_news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.grandtask.core.usecases.RedditNewsUseCase
import com.grandtask.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class RedditNewsViewModel(private val useCase: RedditNewsUseCase) : ViewModel() {
    fun getArticles() = liveData(Dispatchers.IO){
        emit(Resource.loading(null))
        emit(useCase.getArticles())
    }
}