package com.nsj.samplenewsapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nsj.samplenewsapp.presentation.NewsScreen
import com.nsj.samplenewsapp.presentation.screen.NewsDetailScreenScreen
import com.nsj.samplenewsapp.presentation.viewmodels.NewsViewModel
import com.nsj.samplenewsapp.presentation.viewmodels.SharedNewsViewModel

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun AppNavHost(
    newsViewModel: NewsViewModel,
    sharedNewsViewModel: SharedNewsViewModel = viewModel()
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
            sharedNewsViewModel.selectedArticle?.let {
                NewsDetailScreenScreen(newsArticle = it, navController)
            }
        }
    }
}