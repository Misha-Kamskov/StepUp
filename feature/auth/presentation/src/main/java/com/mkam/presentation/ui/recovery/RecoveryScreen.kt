package com.mkam.presentation.ui.recovery

import androidx.compose.foundation.background
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
import com.mkam.presentation.ui.AuthHeaderSection
import com.mkam.theme.components.theme.StepUpTheme
import com.mkam.theme.components.view.InputSection
import com.mkam.theme.components.view.PrimaryButton
import com.mkam.theme.components.view.UniversalHeader

@Composable
fun RecoveryScreen() {
    RecoveryContent()
}

@Composable
fun RecoveryContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp)
    ) {
        UniversalHeader(modifier = Modifier.padding(top = 52.dp), onBackClick = { })

        Spacer(modifier = Modifier.height(32.dp))

        AuthHeaderSection(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            title = "Recovery Password",
            subTitle = "Please Enter Your Email Address\nTo Receive a Verification Code"
        )

        Spacer(modifier = Modifier.height(50.dp))

        var email by rememberSaveable { mutableStateOf("") }
        InputSection(
            label = "Email Address",
            value = email,
            onValueChange = { email = it },
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(40.dp))

        PrimaryButton(modifier = Modifier.fillMaxWidth(), title = "Continue", onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun RecoveryPreviewLight() {
    StepUpTheme(darkTheme = false) {
        RecoveryContent()
    }
}

@Preview(showBackground = true)
@Composable
fun RecoveryPreviewDark() {
    StepUpTheme(darkTheme = true) {
        RecoveryContent()
    }
}