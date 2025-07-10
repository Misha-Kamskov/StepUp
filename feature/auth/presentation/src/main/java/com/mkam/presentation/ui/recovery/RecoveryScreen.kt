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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkam.presentation.ui.AuthHeaderSection
import com.mkam.presentation.ui.EmailSection
import com.mkam.theme.components.theme.StepUpTheme
import com.mkam.theme.components.view.BackButton
import com.mkam.theme.components.view.PrimaryButton

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
        BackButton(modifier = Modifier.padding(top = 52.dp)) {}

        Spacer(modifier = Modifier.height(32.dp))

        AuthHeaderSection(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            title = "Recovery Password",
            subTitle = "Please Enter Your Email Address\nTo Receive a Verification Code"
        )

        Spacer(modifier = Modifier.height(50.dp))

        EmailSection()

        Spacer(modifier = Modifier.height(40.dp))

        PrimaryButton(modifier = Modifier.fillMaxWidth(), title = "Continue", onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun RecoveryPreview() {
    StepUpTheme(darkTheme = true) {
        RecoveryContent()
    }
}