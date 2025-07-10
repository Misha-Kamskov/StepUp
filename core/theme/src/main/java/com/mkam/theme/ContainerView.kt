package com.mkam.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mkam.essentials.Container

@Composable
fun <T> ContainerView(
    container: Container<T>,
    modifier: Modifier = Modifier,
    content: @Composable (T) -> Unit
) {

    Box(modifier){
        container.fold(
            onLoading = {
            },
            onError = {},
            onSuccess = {}
        )
    }
}