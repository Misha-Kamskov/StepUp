package com.mkam.presentation.ui.singup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkam.presentation.ui.AuthButton
import com.mkam.presentation.ui.AuthGoogleButton
import com.mkam.presentation.ui.AuthHeaderSection
import com.mkam.presentation.ui.AuthSingInProposition
import com.mkam.presentation.ui.BackButton
import com.mkam.presentation.ui.EmailSection
import com.mkam.presentation.ui.NameSection
import com.mkam.presentation.ui.PasswordSection
import com.mkam.theme.ui.LightFrame

@Composable
fun SingUpScreen() {
    SingInContent()
}

@Composable
fun SingInContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightFrame)
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp)
        ) {
            BackButton(modifier = Modifier.padding(top = 52.dp)) {}

            Spacer(modifier = Modifier.height(32.dp))

            AuthHeaderSection(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                title = "Create Account",
                subTitle = "Let’s Create Account Together"
            )

            Spacer(modifier = Modifier.height(50.dp))

            NameSection()

            Spacer(modifier = Modifier.height(30.dp))

            EmailSection()

            Spacer(modifier = Modifier.height(30.dp))

            PasswordSection()

            Spacer(modifier = Modifier.height(30.dp))

            AuthButton(title = "Sing Up", onClick = {})

            Spacer(modifier = Modifier.height(30.dp))

            AuthGoogleButton(onClick = {})
        }

        AuthSingInProposition(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun SingInPreview() {
    SingInContent()
}