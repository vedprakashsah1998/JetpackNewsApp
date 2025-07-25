package com.nsj.samplenewsapp.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoadingView(modifier: Modifier = Modifier) = Box(
    modifier = modifier,
    contentAlignment = Alignment.Center
) {
    CircularProgressIndicator()
}


@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    message: String,
    onRetry: (() -> Unit)? = null
) = Box(
    modifier = modifier,
    contentAlignment = Alignment.Center
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = message)
        onRetry?.let {
            Spacer(Modifier.height(8.dp))
            Button(onClick = it) { Text("Try Again") }
        }
    }
}

@Composable
fun <T> StateHandler(
    outcome: Outcome<T>,
    modifier: Modifier = Modifier,
    onRetry: (() -> Unit)? = null,
    content: @Composable (T) -> Unit
) {
    when (outcome) {
        is Outcome.Progress -> LoadingView(modifier)
        is Outcome.Success -> Box(modifier) { content(outcome.data) }
        is Outcome.Failure -> ErrorView(
            modifier = modifier,
            message = outcome.error.message.orEmpty(),
            onRetry = onRetry
        )
        else -> {}
    }
}