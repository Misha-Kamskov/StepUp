package com.mkam.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkam.presentation.R
import com.mkam.theme.ui.DarkFrame
import com.mkam.theme.ui.PrimaryBlue
import com.mkam.theme.ui.StepUpTheme

@Composable
fun SplashScreen() {
    SplashContent()
}

@Composable
fun SplashContent() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkFrame),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(PrimaryBlue)
                .size(150.dp)
                .padding(20.dp)
        ) {
            Image(painter = painterResource(R.drawable.splash_logo), contentDescription = null)
        }
    }

    /*Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightFrame)
    ) {

        Canvas(
            modifier = Modifier
                .size(800.dp)
                .offset(x = 200.dp, y = (-400).dp)
                .align(Alignment.TopEnd)
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            val center = Offset(x = canvasWidth / 2, y = canvasHeight / 2)
            val outerRadius = minOf(canvasWidth, canvasHeight) / 2
            val innerRadius = outerRadius / 2

            drawPath(
                path = Path().apply {
                    addOval(Rect(center = center, radius = outerRadius))
                    addOval(Rect(center = center, radius = innerRadius))
                    fillType = PathFillType.EvenOdd
                },
                color = DarkShape
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.14f)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.logo_splash),
                contentDescription = null
            )

            Column {
                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "Follow Latest\nStyle Shoes",
                    fontSize = 40.sp,
                    lineHeight = TextUnit(56f, TextUnitType.Sp),
                    color = LightThemeText,
                    fontFamily = FontFamily(Font(com.mkam.theme.R.font.airbnb_cereal_app_medium)),
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    modifier = Modifier.padding(start = 20.dp),
                    text = "There Are Many Beautiful And\nAttractive Plants To Your Room",
                    fontSize = 20.sp,
                    lineHeight = TextUnit(32f, TextUnitType.Sp),
                    color = LightThemeSubText,
                    fontFamily = FontFamily(Font(com.mkam.theme.R.font.airbnb_cereal_app_book)),
                )
            }
        }
    }

     */
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    StepUpTheme {
        SplashContent()
    }
}
