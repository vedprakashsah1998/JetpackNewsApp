package com.nsj.samplenewsapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nsj.samplenewsapp.domain.model.NewsArticle
import com.nsj.samplenewsapp.domain.usecase.UpdateNewsDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(val updateNewsDetailUseCase: UpdateNewsDetailUseCase): ViewModel() {
    private val _fullText = MutableStateFlow("")
    val fullText = _fullText.asStateFlow()

    fun fetchWebsiteText(article: NewsArticle) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val document = Jsoup.connect(article.url).get()
                val textContent = document.body().text()
                _fullText.value = textContent

            } catch (e: Exception) {
               val fullDescValue =  listOfNotNull(article.content, article.description).joinToString("\n")
                _fullText.value = fullDescValue
            }
            updateNewsDetailUseCase.invoke(article.url, _fullText.value)
        }
    }


}