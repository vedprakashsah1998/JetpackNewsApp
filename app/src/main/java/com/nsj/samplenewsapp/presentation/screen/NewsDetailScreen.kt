package com.nsj.samplenewsapp.presentation.screen

import android.app.Activity
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.nsj.samplenewsapp.domain.model.NewsArticle
import com.nsj.samplenewsapp.presentation.viewmodels.NewsDetailViewModel
import com.nsj.samplenewsapp.ui.theme.LocalAppColors
import com.nsj.samplenewsapp.ui.theme.SampleNewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@RequiresApi(Build.VERSION_CODES.S) // API 31+
fun NewsDetailScreenScreen(newsArticle: NewsArticle, navController: NavController) {
    val context = LocalContext.current
    val view = LocalView.current
    val viewModel = hiltViewModel<NewsDetailViewModel>()

    LaunchedEffect(Unit) {
        val window = (context as Activity).window
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, view).isAppearanceLightStatusBars = false
    }

    val websiteText by viewModel.fullText.collectAsState()
    LaunchedEffect(newsArticle.url) {
        viewModel.fetchWebsiteText(newsArticle)
    }
    SampleNewsAppTheme {
        val localColor = LocalAppColors.current

        Box(modifier = Modifier.fillMaxSize()) {

            AsyncImage(
                model = newsArticle.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            TopAppBar(
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
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Transparent
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 250.dp, start = 12.dp, end = 12.dp, bottom = 12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .clip(RoundedCornerShape(16.dp))
                        .graphicsLayer {
                            renderEffect = RenderEffect
                                .createBlurEffect(80f, 80f, Shader.TileMode.CLAMP)
                                .asComposeRenderEffect()
                        }
                        .background(Color.White.copy(alpha = 0.15f))
                )
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                    modifier = Modifier.matchParentSize()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .background(Color.Transparent)
                    ) {
                        Text(
                            text = newsArticle.title,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = localColor.textHighEmphasis,
                        )

                        Row(
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
                                text = newsArticle.formattedDate,
                                fontSize = 12.sp,
                                color = localColor.textLowEmphasis
                            )
                        }


                        Text(
                            text = newsArticle.fullHtmlBody?: websiteText,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = localColor.textMediumEmphasis,
                        )

                        /*  Text(
                              text = newsArticle.content ?: "No Content",
                              fontSize = 16.sp,
                              maxLines = 10,
                              fontWeight = FontWeight.Normal,
                              color = localColor.textMediumEmphasis,
                          )*/

                    }


                }
            }
        }
    }
}
