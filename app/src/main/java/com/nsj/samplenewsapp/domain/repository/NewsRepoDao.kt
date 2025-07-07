package com.nsj.samplenewsapp.domain.repository

interface NewsRepoDao {
    suspend fun updateFullHtmlBodyByUrl(url: String, html: String)
}