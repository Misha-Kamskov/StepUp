package com.mkam.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkam.theme.components.theme.StepUpTheme
import com.mkam.theme.components.view.UniversalHeader

@Composable
fun CategoryScreen() {
    CategoryContent()
}

@Composable
fun CategoryContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {

        UniversalHeader(
            modifier = Modifier
                .padding(top = 52.dp)
                .fillMaxWidth(),
            onBackClick = {},
            title = "Category",
            endContent = {
                Box(modifier = Modifier.size(24.dp), contentAlignment = Alignment.Center){
                    Icon(
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary,
                        painter = painterResource(R.drawable.icon_filter),
                        contentDescription = null
                    )
                }

                Box(modifier = Modifier.size(24.dp), contentAlignment = Alignment.Center){
                    Icon(
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary,
                        painter = painterResource(R.drawable.icon_search),
                        contentDescription = null
                    )
                }
            }
        )



    }
}

@Preview(showBackground = true)
@Composable
fun CategoryPreviewLight() {
    StepUpTheme(darkTheme = false) {
        CategoryContent()
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryPreviewDark() {
    StepUpTheme(darkTheme = true) {
        CategoryContent()
    }
}