package com.mkam.presentation.onboard

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mkam.presentation.R
import com.mkam.presentation.onboard.components.OnBoardCard
import com.mkam.theme.ui.DarkShape
import com.mkam.theme.ui.LightFrame
import com.mkam.theme.ui.PrimaryBlue
import com.mkam.theme.ui.StepUpTheme
import kotlinx.coroutines.launch

@Composable
fun OnBoardScreen() {
    OnBoardContent()
}

@Composable
fun OnBoardContent() {
    val pagerState = rememberPagerState(pageCount = { 3 })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightFrame)
    ) {
        DrawDecorativeCanvas(modifier = Modifier.align(Alignment.TopEnd))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.weight(1f))
            PagerSection(pagerState = pagerState)
            BottomSection(pagerState = pagerState)
        }
    }
}

@Composable
fun DrawDecorativeCanvas(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .size(800.dp)
            .offset(x = 200.dp, y = (-400).dp)

    ) {
        val center = Offset(size.width / 2, size.height / 2)
        val outer = minOf(size.width, size.height) / 2
        val inner = outer / 2

        drawPath(
            path = Path().apply {
                addOval(Rect(center, outer))
                addOval(Rect(center, inner))
                fillType = PathFillType.EvenOdd
            },
            color = DarkShape
        )
    }
}

@Composable
fun PagerSection(pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.wrapContentHeight()
    ) { page ->
        OnBoardCard(
            imageId = R.drawable.logo_splash,
            title = "Follow Latest\nStyle Shoes $page",
            subTitle = "There Are Many Beautiful\nAnd Attractive Plants To Your Room"
        )
    }
}

@Composable
fun BottomSection(pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 40.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        PageIndicators(pagerState)

        Button(
            modifier = Modifier.height(54.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            onClick = {
                if (pagerState.currentPage == pagerState.pageCount - 1) {
                    // Navigate to Auth Screen
                } else {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            }
        ) {
            Text(
                text = "Next",
                fontSize = 18.sp,
                lineHeight = 22.sp,
                color = Color.White,
                fontFamily = FontFamily(Font(com.mkam.theme.R.font.airbnb_cereal_app_medium)),
            )
        }
    }
}

@Composable
fun PageIndicators(pagerState: PagerState) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        repeat(pagerState.pageCount) { index ->
            val color by animateColorAsState(
                if (pagerState.currentPage == index) PrimaryBlue else Color(0xFFE5EEF7)
            )
            val width by animateDpAsState(
                if (pagerState.currentPage == index) 35.dp else 8.dp
            )

            Box(
                modifier = Modifier
                    .width(width)
                    .height(5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color)
                    .animateContentSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardPreview() {
    StepUpTheme {
        OnBoardContent()
    }
}
