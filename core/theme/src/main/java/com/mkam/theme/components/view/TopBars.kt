package com.mkam.theme.components.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UniversalHeader(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    title: String? = null,
    endContent: @Composable (RowScope.() -> Unit)? = null
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.CenterStart)
        ) { onBackClick() }

        title?.let {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = it,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        endContent?.let {
            Row(
                modifier = Modifier.align(Alignment.CenterEnd),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                content = it
            )
        }
    }
}

/*
@Composable
fun Header(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.CenterStart)
        ) { onBackClick() }
    }
}

@Composable
fun FavoriteHeader(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.CenterStart)
        ) { onBackClick() }

        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Favourite",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
fun CartHeader(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.CenterStart)
        ) { onBackClick() }

        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "My Cart",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
fun SettingHeader(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.CenterStart)
        ) { onBackClick() }

        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Account & Settings",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

@Composable
fun NotificationHeader(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.CenterStart)
        ) { onBackClick() }

        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Notifications",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium
        )

        TextButton(modifier = Modifier.align(Alignment.CenterEnd), onClick = { }) {
            Text(
                text = "Clear All",
                color = PrimaryBlue,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
fun ProfileHeader(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.CenterStart)
        ) { onBackClick() }


        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Profile",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium
        )

        IconButton(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(44.dp), onClick = {}) {
            Icon(
                modifier = Modifier.size(18.dp),
                tint = PrimaryBlue,
                painter = painterResource(R.drawable.icon_refactor),
                contentDescription = null
            )
        }
    }
}

@Composable
fun SearchHeader(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.CenterStart)
        ) { onBackClick() }

        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Search",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium
        )

        TextButton(modifier = Modifier.align(Alignment.CenterEnd), onClick = { }) {
            Text(
                text = "Cancel",
                color = PrimaryBlue,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
fun ListHeader(modifier: Modifier = Modifier, onBackClick: () -> Unit) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        BackButton(
            modifier = Modifier.align(Alignment.CenterStart)
        ) { onBackClick() }

        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Best Sellers",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium
        )

        Row(
            Modifier
                .align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            IconButton(modifier = Modifier, onClick = {}) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary,
                    painter = painterResource(R.drawable.icon_filter),
                    contentDescription = null
                )
            }

            IconButton(modifier = Modifier, onClick = {}) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary,
                    painter = painterResource(R.drawable.icon_search),
                    contentDescription = null
                )
            }
        }
    }
}
 */