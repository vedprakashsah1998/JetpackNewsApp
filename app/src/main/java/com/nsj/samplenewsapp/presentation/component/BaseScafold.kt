package com.nsj.samplenewsapp.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nsj.samplenewsapp.ui.theme.LocalAppColors

@Composable
fun BaseScaffold(
    modifier: Modifier,
    topBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    val localColor = LocalAppColors.current

    Scaffold(
        modifier = modifier, containerColor = localColor.bgElevation0, topBar = topBar,
        content = content,
    )

}