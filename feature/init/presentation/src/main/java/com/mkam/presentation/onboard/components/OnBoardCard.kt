package com.mkam.presentation.onboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardCard(imageId: Int, title: String, subTitle: String) {
    Column(modifier = Modifier.padding(vertical = 20.dp)) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.14f)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(imageId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(30.dp))

        Column {
            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = subTitle,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}