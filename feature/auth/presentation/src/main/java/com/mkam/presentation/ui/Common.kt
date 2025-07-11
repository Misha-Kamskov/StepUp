package com.mkam.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mkam.presentation.R


@Composable
fun AuthHeaderSection(modifier: Modifier = Modifier, title: String, subTitle: String) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
        )

        Text(
            text = subTitle,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Composable
fun AuthGoogleButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .height(54.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
        onClick = onClick
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(R.drawable.button_icon_google),
                contentDescription = null
            )

            Text(
                text = "Sign in with google",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Composable
fun AuthProposition(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    primaryText: String,
    secondaryText: String? = null,
    primaryTextStyle: TextStyle = MaterialTheme.typography.labelMedium,
    secondaryTextStyle: TextStyle = MaterialTheme.typography.labelSmall,
    primaryTextColor: Color = MaterialTheme.colorScheme.onPrimary,
    secondaryTextColor: Color = MaterialTheme.colorScheme.primary,
    arrangement: Arrangement.Horizontal = Arrangement.spacedBy(2.dp)
) {
    TextButton(modifier = modifier, onClick = onClick) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = arrangement
        ) {
            Text(
                text = primaryText,
                style = primaryTextStyle,
                color = primaryTextColor
            )

            secondaryText?.let {
                Text(
                    text = it,
                    style = secondaryTextStyle,
                    color = secondaryTextColor
                )
            }
        }
    }
}


