package com.mkam.presentation.ui.singin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkam.presentation.ui.AuthGoogleButton
import com.mkam.presentation.ui.AuthHeaderSection
import com.mkam.presentation.ui.AuthProposition
import com.mkam.theme.components.theme.StepUpTheme
import com.mkam.theme.components.view.InputSection
import com.mkam.theme.components.view.PrimaryButton
import com.mkam.theme.components.view.UniversalHeader

@Composable
fun SingInScreen() {
    SingInContent()
}

@Composable
fun SingInContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp)
        ) {
            UniversalHeader(modifier = Modifier.padding(top = 52.dp), onBackClick = { })

            Spacer(modifier = Modifier.height(32.dp))

            AuthHeaderSection(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                title = "Hello Again!",
                subTitle = "Welcome Back You’ve Been Missed!"
            )

            Spacer(modifier = Modifier.height(50.dp))

            var email by rememberSaveable { mutableStateOf("") }
            InputSection(
                label = "Email Address",
                value = email,
                onValueChange = { email = it },
                keyboardType = KeyboardType.Email
            )

            Spacer(modifier = Modifier.height(30.dp))

            var password by rememberSaveable { mutableStateOf("") }
            InputSection(
                label = "Password",
                value = password,
                onValueChange = { password = it },
                isPassword = true
            )

            AuthProposition(
                modifier = Modifier.align(Alignment.End),
                onClick = { /* Navigate to recovery */ },
                primaryText = "Recovery Password",
                secondaryText = null
            )

            Spacer(modifier = Modifier.height(30.dp))

            PrimaryButton(modifier = Modifier.fillMaxWidth(), title = "Sing In", onClick = {})

            Spacer(modifier = Modifier.height(30.dp))

            AuthGoogleButton(onClick = {})
        }

        AuthProposition(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp),
            onClick = { /* Navigate to sign up */ },
            primaryText = "Don’t have an account?",
            secondaryText = "Sign Up for free"
        )

    }
}

@Preview(showBackground = true)
@Composable
fun SingInPreviewLight() {
    StepUpTheme(darkTheme = false) {
        SingInContent()
    }
}

@Preview(showBackground = true)
@Composable
fun SingInPreviewDark() {
    StepUpTheme(darkTheme = true) {
        SingInContent()
    }
}
