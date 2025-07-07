package com.nsj.samplenewsapp.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nsj.samplenewsapp.domain.model.NewsArticle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedNewsViewModel @Inject constructor(): ViewModel() {
    var selectedArticle by mutableStateOf<NewsArticle?>(null)

}