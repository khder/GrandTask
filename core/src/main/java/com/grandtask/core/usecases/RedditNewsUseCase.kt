package com.grandtask.core.usecases

import com.grandtask.core.data.repositories.RedditNewsRepository

class RedditNewsUseCase(private val redditNewsRepository: RedditNewsRepository) {
     fun getArticles() = redditNewsRepository.getArticles()
}