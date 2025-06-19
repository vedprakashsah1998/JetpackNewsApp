package com.nsj.samplenewsapp.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nsj.samplenewsapp.domain.usecase.GetNewsUseCase
import com.nsj.samplenewsapp.presentation.NewsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {
    var uiState by mutableStateOf(NewsUiState())
        private set

    init {
        fetchNews("us")
    }

    private fun fetchNews(country: String) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            try {
                val articles = getNewsUseCase(country)
                uiState = uiState.copy(articles = articles, isLoading = false)
            } catch (e: Exception) {
                uiState = uiState.copy(error = e.message, isLoading = false)
            }
        }
    }

}