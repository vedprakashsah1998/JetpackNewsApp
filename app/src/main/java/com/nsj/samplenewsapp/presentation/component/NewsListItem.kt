package com.nsj.samplenewsapp.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.rememberOverscrollEffect
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nsj.samplenewsapp.domain.model.NewsArticle

@Composable
fun NewsListItem(
    listOfImages: List<NewsArticle>,
    scrollState: LazyListState,
    onItemClick: (NewsArticle) -> Unit,
    from: String
) {
    val overscrollEffect = rememberOverscrollEffect()
    if (from == "Detail") {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            listOfImages.forEach { item ->
                BaseNewsItemCard(onItemClick={onItemClick(item)},item)
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
                BaseNewsItemCard(onItemClick={onItemClick(item)},item)
            }
        }
    }

}