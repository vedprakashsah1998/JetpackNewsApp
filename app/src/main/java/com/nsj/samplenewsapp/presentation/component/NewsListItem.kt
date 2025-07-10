package com.nsj.samplenewsapp.presentation.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.rememberOverscrollEffect
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.nsj.samplenewsapp.domain.model.NewsArticle
import com.nsj.samplenewsapp.ui.theme.LocalAppColors
import com.nsj.samplenewsapp.utils.CustomTabHelper

@Composable
fun NewsListItem(
    listOfImages: List<NewsArticle>,
    scrollState: LazyListState,
    onItemClick: (NewsArticle) -> Unit,
    from: String
) {


    val context = LocalContext.current
    val overscrollEffect = rememberOverscrollEffect()
    val isPressed = remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isPressed.value) 0.97f else 1f,
        animationSpec = tween(150)
    )
    val haptic = LocalHapticFeedback.current
    if (from == "Detail") {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            listOfImages.forEach { item ->

                val descriptionText by remember(item.description) {
                    derivedStateOf {
                        item.description ?: "No description available."
                    }
                }
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            // Optional slight Y translation to simulate iOS bounce
                            translationY = if (scale < 1f) 2f else 0f
                        }
                        .pointerInteropFilter {
                            when (it.action) {
                                android.view.MotionEvent.ACTION_DOWN -> isPressed.value = true
                                android.view.MotionEvent.ACTION_UP,
                                android.view.MotionEvent.ACTION_CANCEL -> isPressed.value = false
                            }
                            false
                        },
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.elevatedCardColors(containerColor = LocalAppColors.current.bgCard),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(LocalAppColors.current.bgCard)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .clip(RoundedCornerShape(14.dp))
                            ) {
                                AsyncImage(
                                    model = item.imageUrl,
                                    contentDescription = "News Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .matchParentSize()
                                        .clip(RoundedCornerShape(14.dp))
                                )

                                // Overlay the gradient from bottom to top
                                Box(
                                    modifier = Modifier
                                        .matchParentSize()
                                        .background(
                                            Brush.verticalGradient(
                                                colors = listOf(
                                                    LocalAppColors.current.imgBgColor,
                                                    Color.Transparent
                                                ),
                                                startY = Float.POSITIVE_INFINITY,
                                                endY = 0f
                                            )
                                        )
                                )
                            }


                            Column(
                                modifier = Modifier
                                    .weight(2f)
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.SpaceAround
                            ) {
                                Text(
                                    text = item.title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = LocalAppColors.current.textHighEmphasis,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.clickable(onClick = {
                                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                        onItemClick(item)
//                                    onTitleClick()

                                    })
                                )


                                Text(
                                    text = descriptionText,
                                    fontSize = 13.sp,
                                    color = LocalAppColors.current.textMediumEmphasis,
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )


                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = "Date",
                                        tint = LocalAppColors.current.textLowEmphasis,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Text(
                                        text = item.formattedDate,
                                        fontSize = 11.sp,
                                        color = LocalAppColors.current.textLowEmphasis
                                    )
                                }
                            }
                        }

                    }
                }
            }
        }
    } else {
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
                .overscroll(overscrollEffect),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(items = listOfImages, key = { it.url }) { item ->
                val onTitleClick = remember(item.url) {
                    {
                        CustomTabHelper.openCustomTab(context, item.url)
                    }
                }
                val descriptionText by remember(item.description) {
                    derivedStateOf {
                        item.description ?: "No description available."
                    }
                }
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            // Optional slight Y translation to simulate iOS bounce
                            translationY = if (scale < 1f) 2f else 0f
                        }
                        .pointerInteropFilter {
                            when (it.action) {
                                android.view.MotionEvent.ACTION_DOWN -> isPressed.value = true
                                android.view.MotionEvent.ACTION_UP,
                                android.view.MotionEvent.ACTION_CANCEL -> isPressed.value = false
                            }
                            false
                        },
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    ),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.elevatedCardColors(containerColor = LocalAppColors.current.bgCard),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(LocalAppColors.current.bgCard)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .clip(RoundedCornerShape(14.dp))
                            ) {
                                AsyncImage(
                                    model = item.imageUrl,
                                    contentDescription = "News Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .matchParentSize()
                                        .clip(RoundedCornerShape(14.dp))
                                )

                                // Overlay the gradient from bottom to top
                                Box(
                                    modifier = Modifier
                                        .matchParentSize()
                                        .background(
                                            Brush.verticalGradient(
                                                colors = listOf(
                                                    LocalAppColors.current.imgBgColor,
                                                    Color.Transparent
                                                ),
                                                startY = Float.POSITIVE_INFINITY,
                                                endY = 0f
                                            )
                                        )
                                )
                            }


                            Column(
                                modifier = Modifier
                                    .weight(2f)
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.SpaceAround
                            ) {
                                Text(
                                    text = item.title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = LocalAppColors.current.textHighEmphasis,
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.clickable(onClick = {
                                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                        onItemClick(item)
//                                    onTitleClick()

                                    })
                                )


                                Text(
                                    text = descriptionText,
                                    fontSize = 13.sp,
                                    color = LocalAppColors.current.textMediumEmphasis,
                                    maxLines = 3,
                                    overflow = TextOverflow.Ellipsis
                                )


                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = "Date",
                                        tint = LocalAppColors.current.textLowEmphasis,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Text(
                                        text = item.formattedDate,
                                        fontSize = 11.sp,
                                        color = LocalAppColors.current.textLowEmphasis
                                    )
                                }
                            }
                        }

                    }
                }
            }
        }
    }

}