package com.nsj.samplenewsapp.presentation

import com.nsj.samplenewsapp.domain.model.NewsArticle

data class NewsUiState(
    val isLoading: Boolean = false,
    val articles: List<NewsArticle> = emptyList(),
    val error: String? = null
)