package com.nsj.samplenewsapp.domain.usecase

import com.nsj.samplenewsapp.domain.model.NewsArticle
import com.nsj.samplenewsapp.domain.repository.NewsRepoSources
import javax.inject.Inject

class NewsRepoSourcesDetailUseCase @Inject constructor(private val newsRepoSources: NewsRepoSources) {
    suspend operator fun invoke(sourcesId: String):List<NewsArticle> {
        return newsRepoSources.getTopSourceHeadLines(sourcesId)
    }
}