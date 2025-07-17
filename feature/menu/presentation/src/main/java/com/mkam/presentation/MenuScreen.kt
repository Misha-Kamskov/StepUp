package com.mkam.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkam.theme.components.theme.PrimaryBlue
import com.mkam.theme.components.theme.StepUpTheme
import com.mkam.theme.components.view.CustomBottomBarShape

@Composable
fun MenuScreen() {
    MenuContent()
}

@Composable
fun MenuContent() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            MenuBottomBar(
                onCartFloatButtonClick = {},
                onNavigationBarItemClick = {}
            )
        },
    )
    { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            //NavHost
        }
    }
}

@Composable
fun MenuBottomBar(
    modifier: Modifier = Modifier,
    onNavigationBarItemClick: () -> Unit,
    onCartFloatButtonClick: () -> Unit
) {
    val icons = listOf(
        com.mkam.theme.R.drawable.icon_home to true,
        com.mkam.theme.R.drawable.icon_favorite to false,
        com.mkam.theme.R.drawable.icon_notification_2 to false,
        com.mkam.theme.R.drawable.icon_profile to false
    )

    Box(modifier = modifier.fillMaxWidth()) {
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(106.dp)
                .shadow(10.dp, CustomBottomBarShape(), true)
                .clip(CustomBottomBarShape()),
            containerColor = MaterialTheme.colorScheme.onBackground,
            tonalElevation = 0.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
                    .height(86.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                icons.take(2).forEach { (iconRes, selected) ->
                    NavigationBarItem(
                        modifier = Modifier.size(34.dp),
                        selected = selected,
                        icon = { Icon(painterResource(iconRes), null) },
                        colors = navigationBarItemColors(),
                        onClick = onNavigationBarItemClick
                    )
                }

                Spacer(Modifier.width(90.dp))

                icons.drop(2).forEach { (iconRes, selected) ->
                    NavigationBarItem(
                        modifier = Modifier.size(34.dp),
                        selected = selected,
                        icon = { Icon(painterResource(iconRes), null) },
                        colors = navigationBarItemColors(),
                        onClick = onNavigationBarItemClick
                    )
                }
            }
        }

        CartFloatButton(
            modifier = Modifier.align(Alignment.TopCenter),
            onClick = onCartFloatButtonClick
        )
    }
}

@Composable
private fun navigationBarItemColors() = NavigationBarItemDefaults.colors(
    unselectedIconColor = Color(0xFF707B81),
    selectedIconColor = PrimaryBlue,
    indicatorColor = Color.Transparent
)

@Composable
fun CartFloatButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    FloatingActionButton(
        modifier = modifier
            .shadow(
                3.dp,
                CircleShape,
                ambientColor = PrimaryBlue,
                spotColor = PrimaryBlue
            ),
        shape = CircleShape,
        onClick = onClick,
        containerColor = PrimaryBlue,
        contentColor = Color.White
    ) {
        Image(
            painter = painterResource(com.mkam.theme.R.drawable.icon_cart),
            contentDescription = null
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MenuPreviewLight() {
    StepUpTheme(darkTheme = false) {
        MenuContent()
    }
}


@Preview(showBackground = true)
@Composable
fun MenuPreviewDark() {
    StepUpTheme(darkTheme = true) {
        MenuContent()
    }
}