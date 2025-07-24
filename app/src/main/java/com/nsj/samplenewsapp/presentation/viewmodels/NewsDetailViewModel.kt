package com.nsj.samplenewsapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nsj.samplenewsapp.domain.model.NewsArticle
import com.nsj.samplenewsapp.domain.usecase.NewsRepoSourcesDetailUseCase
import com.nsj.samplenewsapp.utils.Outcome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import javax.inject.Inject

@HiltViewModel
class NewsDetailViewModel @Inject constructor(
    val newsRepoSourcesUseCase: NewsRepoSourcesDetailUseCase
) : ViewModel() {
    private val _fullText = MutableStateFlow("")
    val fullText = _fullText.asStateFlow()


    private val _uiStateSourceFlow: MutableStateFlow<Outcome<List<NewsArticle>>> =
        MutableStateFlow(Outcome.Progress(true))
    val uiStateSourceFlow: StateFlow<Outcome<List<NewsArticle>>> =
        _uiStateSourceFlow


    fun fetchWebsiteText(article: NewsArticle?) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val document = Jsoup.connect(article?.url ?: "").get()
                val textContent = document.body().text()
                _fullText.value = basicExtractiveSummary(textContent)

            } catch (e: Exception) {
                val fullDescValue =
                    listOfNotNull(article?.content, article?.description).joinToString("\n")
                _fullText.value = fullDescValue
            }
        }
    }

    fun fetchWebSourceNews(sourceId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val articles = newsRepoSourcesUseCase.invoke(sourceId)
                _uiStateSourceFlow.value = Outcome.Success(articles)
            } catch (e: Exception) {
                _uiStateSourceFlow.value = Outcome.Failure(e)
            }
        }
    }

    private fun basicExtractiveSummary(text: String, maxWords: Int = 100): String {
        if (text.isBlank()) return ""

        val sentences = text.split(Regex("(?<=[.!?])\\s+"))
        val scoredSentences = sentences.map { sentence ->
            val wordCount = sentence.split(Regex("\\s+")).size
            val score = sentence.length.toDouble() / wordCount
            sentence to score
        }

        val sortedSentences = scoredSentences.sortedByDescending { it.second }

        val summary = StringBuilder()
        var currentWordCount = 0

        for ((sentence, _) in sortedSentences) {
            val sentenceWordCount = sentence.split(Regex("\\s+")).size
            if (currentWordCount + sentenceWordCount > maxWords) break

            summary.append(sentence).append(" ")
            currentWordCount += sentenceWordCount
        }

        return summary.toString().trim()
    }


}