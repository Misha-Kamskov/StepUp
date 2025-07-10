package com.mkam.presentation.onboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mkam.theme.ui.LightThemeSubText
import com.mkam.theme.ui.LightThemeText

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
                fontSize = 40.sp,
                lineHeight = TextUnit(56f, TextUnitType.Sp),
                color = LightThemeText,
                fontFamily = FontFamily(Font(com.mkam.theme.R.font.airbnb_cereal_app_medium)),
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.padding(start = 20.dp),
                text = subTitle,
                fontSize = 20.sp,
                lineHeight = TextUnit(32f, TextUnitType.Sp),
                color = LightThemeSubText,
                fontFamily = FontFamily(Font(com.mkam.theme.R.font.airbnb_cereal_app_book)),
            )
        }
    }
}