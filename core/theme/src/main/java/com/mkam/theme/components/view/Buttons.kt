package com.mkam.theme.components.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkam.theme.R
import com.mkam.theme.components.theme.PrimaryBlue
import com.mkam.theme.components.theme.StepUpTheme

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    title: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.height(54.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
        onClick = onClick
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = Color.White,
        )
    }
}


@Composable
fun BackButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    IconButton(
        modifier = modifier
            .size(44.dp)
            .clip(CircleShape),
        colors = IconButtonDefaults.iconButtonColors(

            containerColor = MaterialTheme.colorScheme.onBackground
        ),
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(R.drawable.arrow_left),
            tint = MaterialTheme.colorScheme.primary, contentDescription = null
        )
    }
}

@Preview
@Composable
fun ButtonsPreview() {
    StepUpTheme(darkTheme = false) {
        Column(
            modifier = Modifier.background(Color.DarkGray),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            PrimaryButton(title = "Continue") {}

            BackButton {}


        }
    }
}