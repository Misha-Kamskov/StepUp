package com.mkam.theme.components.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mkam.theme.R

val CerealMedium = FontFamily(Font(R.font.airbnb_cereal_app_medium))
val CerealBook = FontFamily(Font(R.font.airbnb_cereal_app_book))

val CustomTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = CerealMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 40.sp,
        lineHeight = 56.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = CerealMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp,
        lineHeight = 36.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = CerealMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 32.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = CerealBook,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = CerealMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 20.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = CerealMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 22.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = CerealBook,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = CerealMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    )
)
