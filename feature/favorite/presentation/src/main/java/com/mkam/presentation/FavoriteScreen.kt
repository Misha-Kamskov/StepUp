package com.mkam.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkam.theme.components.theme.PrimaryBlue
import com.mkam.theme.components.theme.StepUpTheme
import com.mkam.theme.components.view.UniversalHeader

@Composable
fun FavoriteScreen() {
    FavoriteContent()
}

@Composable
fun FavoriteContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {

        UniversalHeader(
            modifier = Modifier.padding(top = 52.dp).fillMaxWidth(),
            onBackClick = {},
            title = "Favourite"
        )

        LazyVerticalGrid(
            modifier = Modifier
                .padding(vertical = 24.dp)
                .fillMaxSize(),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            items(4) {
                FavoriteItemCard()
            }
        }
    }
}

@Composable
fun FavoriteItemCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onBackground)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(vertical = 14.dp)) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 14.dp)
                    .fillMaxWidth()
                    .height(90.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(R.drawable.test_shoes_photo_2),
                    contentDescription = null
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(28.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        painter = painterResource(R.drawable.icon_favorite),
                        tint = Color(0xFFF87265),
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "BEST SELLER",
                style = MaterialTheme.typography.labelMedium,
                color = PrimaryBlue
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = "Nike Air Max",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$58.7",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    listOf(Color(0xFF7DDBDA), Color(0xFF606ACB)).forEach { color ->
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .clip(CircleShape)
                                .background(color)
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FavoritePreviewLight() {
    StepUpTheme(darkTheme = false) {
        FavoriteContent()
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritePreviewDark() {
    StepUpTheme(darkTheme = true) {
        FavoriteContent()
    }
}