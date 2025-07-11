package com.mkam.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkam.theme.components.theme.PrimaryBlue
import com.mkam.theme.components.theme.StepUpTheme
import com.mkam.theme.components.view.UniversalHeader

@Composable
fun SettingsScreen() {
    SettingsContent()
}

@Composable
fun SettingsContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp),
    ) {
        UniversalHeader(
            modifier = Modifier.padding(top = 52.dp),
            onBackClick = { /* ... */ },
            title = "Account & Settings",
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            SettingSection(title = "Account", items = AccountSetting.entries.map { setting ->
                @Composable {
                    SettingsListItem(
                        iconId = setting.icon,
                        title = setting.title,
                        onClick = { }
                    )
                }
            })

            Spacer(modifier = Modifier.height(40.dp))

            SettingSection(title = "App Settings", items = AppSetting.entries.map { setting ->

                @Composable {
                    var switchValue by rememberSaveable { mutableStateOf(false) }

                    SettingsListItem(
                        title = setting.title,
                        isSwitch = true,
                        switchValue = switchValue,
                        onCheckedChange = { switchValue = it },
                        onClick = { }
                    )
                }
            })
        }
    }
}

@Composable
fun SettingSection(
    modifier: Modifier = Modifier,
    title: String,
    items: List<@Composable () -> Unit>
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium,
        )

        items.forEach { it() }
    }
}

@Composable
fun SettingsListItem(
    iconId: Int? = null,
    title: String,
    isSwitch: Boolean = false,
    switchValue: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
    onClick: () -> Unit = { }
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
    ) {
        Spacer(Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            iconId?.let { icon ->
                Box(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(icon),
                        tint = Color(0xFF707B81),
                        contentDescription = null
                    )
                }
            }

            Text(
                text = title,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )

            if (isSwitch) {
                GradientSwitch(
                    checked = switchValue,
                    onCheckedChange = onCheckedChange
                )
            } else {
                Icon(
                    painter = painterResource(R.drawable.icon_arrow_right),
                    tint = Color(0xFF707B81),
                    contentDescription = null
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        SolidLine()

    }
}

@Composable
fun GradientSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val thumbPosition by animateFloatAsState(
        targetValue = if (checked) 1f else 0f,
        label = "ThumbPosition"
    )
    val circleRadius = 10.dp
    val interactionSource = remember { MutableInteractionSource() }
    val uncheckedColor = MaterialTheme.colorScheme.tertiary

    Box(
        modifier = modifier
            .size(width = 42.dp, height = 24.dp)
            .background(color = Color.Transparent)
            .clickable(
                onClick = { onCheckedChange(!checked) },
                interactionSource = interactionSource,
                indication = null
            )
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val trackBrush = if (checked) {
                SolidColor(PrimaryBlue)
            } else {
                SolidColor(uncheckedColor)
            }

            drawRoundRect(
                brush = trackBrush,
                size = size,
                cornerRadius = CornerRadius(x = 12.dp.toPx(), y = 12.dp.toPx())
            )

            val thumbOffset = calculateThumbOffset(
                start = 12.dp.toPx(),
                stop = size.width - 12.dp.toPx(),
                fraction = thumbPosition
            )

            drawCircle(
                color = Color.White,
                radius = circleRadius.toPx(),
                center = Offset(x = thumbOffset, y = size.height / 2)
            )
        }
    }
}

@Composable
fun SolidLine(
    color: Color = MaterialTheme.colorScheme.onPrimary,
    strokeWidth: Float = 0.5f,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(0.5.dp)
) {
    Canvas(modifier = modifier) {
        drawLine(
            color = color,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = strokeWidth
        )
    }
}


private fun calculateThumbOffset(
    start: Float,
    stop: Float,
    fraction: Float
): Float = start + (stop - start) * fraction


@Preview(showBackground = true)
@Composable
fun SettingsPreviewLight() {
    StepUpTheme(darkTheme = false) {
        SettingsContent()
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreviewDark() {
    StepUpTheme(darkTheme = true) {
        SettingsContent()
    }
}