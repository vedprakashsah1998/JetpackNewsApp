package com.nsj.samplenewsapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nsj.samplenewsapp.domain.model.NewsArticle
import com.nsj.samplenewsapp.domain.usecase.GetNewsUseCase
import com.nsj.samplenewsapp.utils.Outcome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _uiStateFlow: MutableStateFlow<Outcome<List<NewsArticle>>> =
        MutableStateFlow(Outcome.Progress(true))
    val uiStateFlow: StateFlow<Outcome<List<NewsArticle>>> =
        _uiStateFlow

    init {
        fetchNews()
    }

    fun fetchNews() {
        viewModelScope.launch {
            try {
                val articles = getNewsUseCase()
                _uiStateFlow.value = Outcome.Success(articles)
            } catch (e: Exception) {
                _uiStateFlow.value = Outcome.Failure(e)
            }
        }
    }

}