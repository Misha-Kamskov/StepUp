package com.mkam.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mkam.theme.components.theme.PrimaryBlue
import com.mkam.theme.components.theme.StepUpTheme
import com.mkam.theme.components.view.PrimaryButton
import com.mkam.theme.components.view.UniversalHeader

@Composable
fun CartScreen() {
    CartContent()
}

@Composable
fun CartContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        UniversalHeader(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(top = 52.dp)
                .fillMaxWidth(),
            onBackClick = {},
            title = "My Cart"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {

                items(10) {
                    CartItemCard(
                        title = "Nike Air Max 200",
                        price = "$64.95",
                        size = "XL",
                        quantity = 1,
                        onAdd = {},
                        onRemove = {},
                        onDelete = {}
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(270.dp))
                }
            }

            CartSummary(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Composable
fun CartItemCard(
    title: String,
    price: String,
    size: String,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(width = 87.dp, height = 85.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.onBackground),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.test_shoes_photo),
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .weight(1f)
                .height(80.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = title, style = itemTextStyle())

                    Text(text = size, style = itemTextStyle())
                }

                Spacer(Modifier.height(4.dp))

                Text(price, style = itemTextStyle())
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {

                    IconCircleButton(
                        iconRes = R.drawable.icon_minus,
                        bgColor = MaterialTheme.colorScheme.onBackground,
                        iconTint = Color(0xFF828A89),
                        onClick = { onRemove() }
                    )

                    Text(
                        text = quantity.toString(),
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        color = MaterialTheme.colorScheme.primary,
                        fontFamily = FontFamily(Font(com.mkam.theme.R.font.switzer_regular))
                    )

                    IconCircleButton(
                        iconRes = R.drawable.icon_add,
                        bgColor = PrimaryBlue,
                        iconTint = Color.White,
                        onClick = onAdd
                    )
                }

                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .clickable { onDelete() },
                    painter = painterResource(R.drawable.icon_bin),
                    contentDescription = null,
                    tint = Color(0xFFF87265)
                )

            }
        }
    }
}

@Composable
fun IconCircleButton(
    iconRes: Int,
    bgColor: Color,
    iconTint: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .background(bgColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            tint = iconTint,
            modifier = Modifier.size(10.dp)
        )
    }
}

@Composable
fun CartSummary(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 23.dp, topEnd = 23.dp))
            .background(MaterialTheme.colorScheme.onBackground)
            .padding(horizontal = 22.dp, vertical = 24.dp)
    ) {
        LabelWithPrice("Subtotal", "$1250.00", MaterialTheme.colorScheme.onPrimary)

        Spacer(modifier = Modifier.height(18.dp))

        LabelWithPrice("Shipping", "$40.90", MaterialTheme.colorScheme.onPrimary)

        Spacer(modifier = Modifier.height(24.dp))

        DashedLine()

        Spacer(modifier = Modifier.height(16.dp))

        LabelWithPrice("Total Cost", "$1690.99", MaterialTheme.colorScheme.primary)

        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(modifier = Modifier.fillMaxWidth(), title = "Checkout") { }
    }
}

@Composable
fun LabelWithPrice(label: String, value: String, labelColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = labelColor,
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = value,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun DashedLine(
    color: Color = MaterialTheme.colorScheme.onPrimary,
    strokeWidth: Float = 2f,
    dashLength: Float = 10f,
    gapLength: Float = 10f,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
) {
    Canvas(modifier = modifier) {
        drawLine(
            color = color,
            start = Offset(0f, size.height / 2),
            end = Offset(size.width, size.height / 2),
            strokeWidth = strokeWidth,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, gapLength))
        )
    }
}

@Composable
fun itemTextStyle() = TextStyle(
    fontSize = 14.sp,
    lineHeight = 20.sp,
    color = MaterialTheme.colorScheme.primary,
    fontFamily = FontFamily(Font(com.mkam.theme.R.font.airbnb_cereal_app_medium)),
    fontWeight = FontWeight.Medium
)

@Preview(showBackground = true)
@Composable
fun CartPreviewLight() {
    StepUpTheme(darkTheme = false) {
        CartContent()
    }
}

@Preview(showBackground = true)
@Composable
fun CartPreviewDark() {
    StepUpTheme(darkTheme = true) {
        CartContent()
    }
}