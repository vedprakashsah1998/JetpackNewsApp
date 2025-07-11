package com.nsj.samplenewsapp.utils

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nsj.samplenewsapp.presentation.NewsScreen
import com.nsj.samplenewsapp.presentation.screen.NewsDetailScreen
import com.nsj.samplenewsapp.presentation.viewmodels.NewsViewModel
import com.nsj.samplenewsapp.presentation.viewmodels.SharedNewsViewModel

@Composable
fun AppNavHost(
    newsViewModel: NewsViewModel,
    sharedNewsViewModel: SharedNewsViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "news_list") {
        composable(NEWS_LIST_SCREEN) {
            NewsScreen(
                viewmodel = newsViewModel,
                navController = navController,
                sharedViewModel = sharedNewsViewModel
            )
        }

        composable(NEWS_DETAIL_SCREEN) {
            NewsDetailScreen(sharedNewsViewModel,navController)

        }
    }
}