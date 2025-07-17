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