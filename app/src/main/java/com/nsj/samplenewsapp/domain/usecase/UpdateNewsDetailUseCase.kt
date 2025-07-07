package com.nsj.samplenewsapp.domain.usecase

import com.nsj.samplenewsapp.domain.repository.NewsRepoDao
import javax.inject.Inject

class UpdateNewsDetailUseCase @Inject constructor(private val newsRepoDao: NewsRepoDao) {
    suspend operator fun invoke(url: String, html: String) {
        newsRepoDao.updateFullHtmlBodyByUrl(url, html)
    }

}