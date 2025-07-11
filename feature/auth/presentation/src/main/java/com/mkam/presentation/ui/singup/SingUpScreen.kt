package com.mkam.presentation.ui.singup

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
fun SingUpScreen() {
    SingUpContent()
}

@Composable
fun SingUpContent() {
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
                title = "Create Account",
                subTitle = "Let’s Create Account Together"
            )

            Spacer(modifier = Modifier.height(50.dp))

            var name by rememberSaveable { mutableStateOf("") }
            InputSection(
                label = "Your Name",
                value = name,
                onValueChange = { name = it }
            )

            Spacer(modifier = Modifier.height(30.dp))

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

            Spacer(modifier = Modifier.height(30.dp))

            PrimaryButton(modifier = Modifier.fillMaxWidth(), title = "Sing Up", onClick = {})

            Spacer(modifier = Modifier.height(30.dp))

            AuthGoogleButton(onClick = {})
        }

        AuthProposition(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp),
            onClick = { /* Navigate to sign in */ },
            primaryText = "Already have an account?",
            secondaryText = "Sign in"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SingInPreviewLight() {
    StepUpTheme(darkTheme = false) {
        SingUpContent()
    }
}

@Preview(showBackground = true)
@Composable
fun SingInPreviewDark() {
    StepUpTheme(darkTheme = true) {
        SingUpContent()
    }
}
