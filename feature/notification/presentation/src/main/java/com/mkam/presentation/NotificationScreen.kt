package com.mkam.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkam.theme.components.theme.PrimaryBlue
import com.mkam.theme.components.theme.StepUpTheme
import com.mkam.theme.components.view.UniversalHeader

@Composable
fun NotificationScreen() {
    NotificationContent()
}

@Composable
fun NotificationContent() {
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
            title = "Notifications",
            endContent = {
                TextButton(onClick = { }) {
                    Text(
                        text = "Clear All",
                        style = MaterialTheme.typography.titleSmall,
                        color = PrimaryBlue
                    )
                }
            })

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            repeat(3) {
                stickyHeader {
                    NotificationSectionHeader(
                        modifier = Modifier.padding(
                            top = if (it != 0) 20.dp else 0.dp,
                        ), title = "Today"
                    )
                }

                items(2) {
                    OfferNotificationCard(
                        title = "We Have New Products With Offers",
                        newPrice = "$290.00",
                        oldPrice = "$364.95",
                        isRead = false,
                        date = "6 min ago"
                    )
                }
            }
        }
    }
}

@Composable
fun NotificationSectionHeader(modifier: Modifier = Modifier, title: String) {
    Box(modifier = modifier.fillMaxWidth()) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun OfferNotificationCard(
    modifier: Modifier = Modifier,
    title: String,
    newPrice: String,
    oldPrice: String,
    isRead: Boolean,
    date: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(85.dp)
    ) {
        Box(
            modifier = Modifier
                .size(width = 87.dp, height = 85.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.onBackground),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.test_shoes_photo),
                contentDescription = null
            )
        }

        Column(
            modifier = Modifier
                .padding(vertical = 6.5.dp, horizontal = 14.dp)
                .fillMaxHeight()
                .weight(1f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = newPrice,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = oldPrice,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }

        Box(modifier = Modifier.fillMaxHeight()) {
            Text(
                modifier = Modifier.align(Alignment.TopEnd),
                text = date,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleSmall
            )

            Box(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(if (isRead) PrimaryBlue else MaterialTheme.colorScheme.onPrimary)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NotificationPreviewLight() {
    StepUpTheme(darkTheme = false) {
        NotificationContent()
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationPreviewDark() {
    StepUpTheme(darkTheme = true) {
        NotificationContent()
    }
}