package com.nsj.samplenewsapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.nsj.samplenewsapp.presentation.component.NewsListItem
import com.nsj.samplenewsapp.presentation.viewmodels.NewsViewModel
import com.nsj.samplenewsapp.ui.theme.LocalAppColors
import com.nsj.samplenewsapp.ui.theme.SampleNewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(viewmodel: Lazy<NewsViewModel>) {
    SampleNewsAppTheme {
        val scrollState = rememberLazyListState()
        val uiState = viewmodel.value.uiState
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            "Trending News",
                            color = LocalAppColors.current.textHighEmphasis
                        )
                    },
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = LocalAppColors.current.bgBottomNavigation)
                )
            },
        ) { innerPadding ->

            if (uiState.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else if (uiState.error != null) {
                Text(text = uiState.error)
            } else {
                Box(modifier = Modifier.padding(innerPadding)) {
                    NewsListItem(uiState.articles, scrollState)
                }

            }

        }
    }

}