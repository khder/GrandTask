package com.grandtask.core.usecases

import com.grandtask.core.data.repositories.RedditNewsRepository

class RedditNewsUseCase(private val redditNewsRepository: RedditNewsRepository) {
    suspend fun getArticles() = redditNewsRepository.getArticles()
}