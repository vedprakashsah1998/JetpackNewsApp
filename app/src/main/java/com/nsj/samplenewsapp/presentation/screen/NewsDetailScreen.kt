package com.nsj.samplenewsapp.presentation.screen

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.nsj.samplenewsapp.domain.model.NewsArticle
import com.nsj.samplenewsapp.presentation.component.NewsListItem
import com.nsj.samplenewsapp.presentation.viewmodels.NewsDetailViewModel
import com.nsj.samplenewsapp.presentation.viewmodels.SharedNewsViewModel
import com.nsj.samplenewsapp.ui.theme.LocalAppColors
import com.nsj.samplenewsapp.ui.theme.SampleNewsAppTheme
import com.nsj.samplenewsapp.utils.NEWS_DETAIL_SCREEN
import com.nsj.samplenewsapp.utils.StateHandler

@SuppressLint("UnrememberedGetBackStackEntry")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailScreen(sharedNewsViewModel: SharedNewsViewModel, navController: NavController) {
    val context = LocalContext.current
    val view = LocalView.current
    val viewModel = hiltViewModel<NewsDetailViewModel>()
    val newsArticle = sharedNewsViewModel.selectedArticle
    key(newsArticle?.url) {
        NewsDetailScreenContent(newsArticle, sharedNewsViewModel, navController,viewModel)
    }
    LaunchedEffect(Unit) {
        val window = (context as Activity).window
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, view).isAppearanceLightStatusBars = false
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetailScreenContent(
    newsArticle: NewsArticle?,
    sharedNewsViewModel: SharedNewsViewModel,
    navController: NavController,
    viewModel: NewsDetailViewModel
) {
    val sourceIdMain = if (newsArticle?.sourceId?.isEmpty() == true) "cnn" else newsArticle?.sourceId

    val websiteText by viewModel.fullText.collectAsState()
    LaunchedEffect(newsArticle?.url) {
        viewModel.fetchWebsiteText(newsArticle)
        viewModel.fetchWebSourceNews(sourceIdMain ?: "cnn")
    }
    val uiState = viewModel.uiStateSourceFlow.collectAsState().value

    val description = newsArticle?.fullHtmlBody.takeUnless { it.isNullOrEmpty() } ?: websiteText


    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val maxImageHeight = 250.dp
    val collapseFraction = scrollBehavior.state.collapsedFraction
    val imageHeight = lerp(maxImageHeight, 0.dp, collapseFraction)

    SampleNewsAppTheme {
        val localColor = LocalAppColors.current

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            containerColor = localColor.bgElevation0,
            topBar = {
                LargeTopAppBar(
                    title = {},
                    navigationIcon = {
                        Box(
                            modifier = Modifier
                                .padding(start = 16.dp, top = 16.dp)
                                .size(36.dp)
                                .clip(CircleShape)
                        ) {
                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .graphicsLayer { alpha = 0.99f }
                                    .blur(radius = 16.dp)
                                    .clickable { navController.popBackStack() }
                                    .background(Color.Black.copy(alpha = 0.3f))
                            )
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color.White,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(20.dp)
                            )
                        }

                    },
                    actions = {
                        Box(
                            modifier = Modifier
                                .padding(end = 16.dp, top = 16.dp)
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(Color.Black.copy(alpha = 0.3f))
                        ) {
                            Box(
                                modifier = Modifier
                                    .matchParentSize()
                                    .graphicsLayer { alpha = 0.99f }
                                    .blur(radius = 16.dp)
                                    .background(Color.Black.copy(alpha = 0.3f))
                            )
                            Icon(
                                imageVector = Icons.Filled.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = Color.White,
                                modifier = Modifier
                                    .align(Alignment.Center) // Center the icon
                                    .size(20.dp)
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                    colors = TopAppBarDefaults.largeTopAppBarColors(
                        containerColor = Color.Transparent,
                        scrolledContainerColor = Color(0x66000000)
                    ),
                    modifier = Modifier
                        .background(Color.Transparent),
                )
            },

            content = {innerPadding->
                val scrollState = rememberLazyListState()

                Box {
                    AsyncImage(
                        model = newsArticle?.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(imageHeight)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(imageHeight)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.5f),
                                    Color.Transparent
                                )
                            )
                        )
                )
                LazyColumn(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .nestedScroll(scrollBehavior.nestedScrollConnection),
                    state = scrollState,
                    contentPadding = PaddingValues(
                        top = 68.dp,
                        bottom = innerPadding.calculateBottomPadding()
                    )
                ) {

                    item {
                        Text(
                            text = newsArticle?.title.toString(),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = localColor.textHighEmphasis,
                            modifier = Modifier.padding(12.dp)
                        )
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.DateRange,
                                contentDescription = "Date",
                                tint = localColor.textLowEmphasis,
                                modifier = Modifier.size(14.dp)
                            )
                            Text(
                                text = newsArticle?.formattedDate.toString(),
                                fontSize = 12.sp,
                                color = localColor.textLowEmphasis
                            )
                        }


                        Text(
                            text = description,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = localColor.textMediumEmphasis,
                            modifier = Modifier.animateContentSize(
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioLowBouncy,
                                    stiffness = Spring.StiffnessLow
                                )
                            ).padding(12.dp)
                        )
                    }


                    item {
                        StateHandler(
                            outcome = uiState,
                            modifier = Modifier
                                .fillMaxSize(),
                            onRetry = { viewModel.fetchWebSourceNews(newsArticle?.sourceId ?: "cnn") }
                        ) { articles ->
                            NewsListItem(
                                articles,
                                scrollState,
                                onItemClick = { article ->
                                    sharedNewsViewModel.selectedArticle = article
                                    navController.navigate(NEWS_DETAIL_SCREEN){
                                        launchSingleTop = true

                                    }
                                },
                                from = "Detail"
                            )

                        }
                    }


                }

            }
        )
    }
}

