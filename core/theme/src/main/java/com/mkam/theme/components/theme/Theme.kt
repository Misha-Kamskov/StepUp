package com.mkam.theme.components.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val CustomDarkColorScheme = darkColorScheme(
    primary = Text100,
    onPrimary = SubText50,
    secondary = PrimaryBlue,
    background = Frame15,
    onBackground = Shape10,
    tertiary = Shape10
)


private val CustomLightColorScheme = lightColorScheme(
    primary = Text10,
    onPrimary = SubText50,
    secondary = PrimaryBlue,
    background = Frame95,
    onBackground = Shape100,
    tertiary = Tertiary10
)


@Composable
fun StepUpTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> CustomDarkColorScheme
        else -> CustomLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = CustomTypography,
        content = content
    )
}