package com.mkam.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mkam.theme.components.theme.PrimaryBlue
import com.mkam.theme.components.theme.StepUpTheme
import com.mkam.theme.components.view.InputSection
import com.mkam.theme.components.view.UniversalHeader

@Composable
fun ProfileScreen() {
    SettingsContent()
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp),
    ) {
        UniversalHeader(
            modifier = Modifier.padding(top = 52.dp),
            onBackClick = { /* ... */ },
            title = "Profile",
            endContent = {
                IconButton(onClick = {}) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        tint = PrimaryBlue,
                        painter = painterResource(R.drawable.icon_refactor),
                        contentDescription = null
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        ProfileAvatar(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            name = "Alisson Becker"
        )

        Spacer(modifier = Modifier.height(32.dp))

        var name by rememberSaveable { mutableStateOf("Alisson Becker") }
        InputSection(
            label = "Your Name",
            value = name,
            onValueChange = { name = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        var email by rememberSaveable { mutableStateOf("alossonBecker@gmail.com") }
        InputSection(
            label = "Email Address",
            value = email,
            onValueChange = { email = it },
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(16.dp))

        var password by rememberSaveable { mutableStateOf("12345678910") }
        InputSection(
            label = "Password",
            value = password,
            onValueChange = { password = it },
            isPassword = true
        )
    }
}


@Composable
fun ProfileAvatar(modifier: Modifier = Modifier, name: String) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.height(100.dp)) {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFDFEFFF))
            )

            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(PrimaryBlue)
                    .align(Alignment.BottomCenter),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    tint = Color.White,
                    painter = painterResource(R.drawable.icon_camera),
                    contentDescription = null
                )
            }
        }

        Text(
            text = name,
            fontSize = 20.sp,
            lineHeight = 28.sp,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = FontFamily(Font(com.mkam.theme.R.font.airbnb_cereal_app_medium)),
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreviewLight() {
    StepUpTheme(darkTheme = false) {
        ProfileContent()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreviewDark() {
    StepUpTheme(darkTheme = true) {
        ProfileContent()
    }
}