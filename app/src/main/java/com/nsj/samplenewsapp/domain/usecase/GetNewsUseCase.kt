package com.nsj.samplenewsapp.domain.usecase

import com.nsj.samplenewsapp.domain.model.NewsArticle
import com.nsj.samplenewsapp.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    suspend operator fun invoke(): List<NewsArticle> {
        return repository.getTopHeadlines()
    }
}