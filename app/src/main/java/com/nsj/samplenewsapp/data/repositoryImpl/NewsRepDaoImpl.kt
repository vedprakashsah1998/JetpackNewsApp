package com.nsj.samplenewsapp.data.repositoryImpl

import com.nsj.samplenewsapp.data.dao.NewsDao
import com.nsj.samplenewsapp.domain.repository.NewsRepoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRepDaoImpl(    private val dao: NewsDao
) : NewsRepoDao {
    override suspend fun updateFullHtmlBodyByUrl(url: String, html: String) {
        withContext(Dispatchers.IO){
            dao.updateFullHtmlBodyByUrl(url, html)
        }
    }
}