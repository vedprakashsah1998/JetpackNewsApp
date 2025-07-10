package com.nsj.samplenewsapp.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.nsj.samplenewsapp.presentation.component.NewsListItem
import com.nsj.samplenewsapp.presentation.viewmodels.NewsViewModel
import com.nsj.samplenewsapp.presentation.viewmodels.SharedNewsViewModel
import com.nsj.samplenewsapp.ui.theme.LocalAppColors
import com.nsj.samplenewsapp.ui.theme.SampleNewsAppTheme
import com.nsj.samplenewsapp.utils.NEWS_DETAIL_SCREEN
import com.nsj.samplenewsapp.utils.StateHandler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(
    viewmodel: NewsViewModel, navController: NavController,
    sharedViewModel: SharedNewsViewModel
) {

    SampleNewsAppTheme {
        val scrollState = rememberLazyListState()
        val uiState = viewmodel.uiStateFlow.collectAsState().value
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            containerColor = LocalAppColors.current.bgElevation0,
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

            StateHandler(
                outcome = uiState,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                onRetry = { viewmodel.fetchNews() }
            ) { articles ->
                NewsListItem(
                    articles,
                    scrollState,
                    onItemClick = { article ->
                        sharedViewModel.selectedArticle = article
                        navController.navigate(NEWS_DETAIL_SCREEN)
                    },
                    from = "Main")

            }

            /* when (uiState) {
                 is Outcome.Progress -> {
                     Box(
                         modifier = Modifier
                             .fillMaxSize()
                             .padding(innerPadding),
                         contentAlignment = Alignment.Center
                     ) {
                         CircularProgressIndicator()
                     }
                 }

                 is Outcome.Success -> {
                     Box(modifier = Modifier.padding(innerPadding)) {
                         NewsListItem(
                             uiState.data,
                             scrollState,
                             onItemClick = { article ->
                                 sharedViewModel.selectedArticle = article
                                 navController.navigate(NEWS_DETAIL_SCREEN)
                             })
                     }
                 }

                 is Outcome.Failure -> {
                     Text(text = uiState.error.message.toString())

                 }

                 is Outcome.Unknown<*> -> {

                 }
             }
 */
        }
    }

}


