package com.mkam.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mkam.presentation.R
import kotlinx.coroutines.launch


@Composable
fun AuthHeaderSection(modifier: Modifier = Modifier, title: String, subTitle: String) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
        )

        Text(
            text = subTitle,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}

@Composable
fun AuthGoogleButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .height(54.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
        onClick = onClick
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(R.drawable.button_icon_google),
                contentDescription = null
            )

            Text(
                text = "Sign in with google",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Composable
fun AuthSingUpProposition(modifier: Modifier = Modifier, onClick: () -> Unit) {
    TextButton(modifier = modifier, onClick = onClick) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "Don’t have an account?",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                text = "Sign Up for free",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Composable
fun AuthSingInProposition(modifier: Modifier = Modifier, onClick: () -> Unit) {
    TextButton(modifier = modifier, onClick = onClick) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "Already have an account?",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
            Text(
                text = "Sign in",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}

@Composable
fun RecoveryPasswordProposition(modifier: Modifier = Modifier, onClick: () -> Unit) {
    TextButton(modifier = modifier, onClick = onClick) {
        Text(
            text = "Recovery Password",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}


@Composable
fun NameSection() {
    Column(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = "Your Name",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
        )

        val bringIntoViewRequester = remember { BringIntoViewRequester() }
        val coroutineScope = rememberCoroutineScope()

        val focusRequester = remember { FocusRequester() }
        var name by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            isError = false,
            shape = RoundedCornerShape(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.onBackground,
                unfocusedContainerColor = MaterialTheme.colorScheme.onBackground,
                errorContainerColor = MaterialTheme.colorScheme.onBackground,
                cursorColor = Color(0xFFCCCCCC),
                errorBorderColor = Color(0xFFDB0F4E),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = Color(0xFF3C4043),
                unfocusedTextColor = Color(0xFF3C4043),
                errorTextColor = Color(0xFFDB0F4E)
            ),
            modifier = Modifier
                .height(54.dp)
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .bringIntoViewRequester(bringIntoViewRequester)
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        coroutineScope.launch {
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Font(com.mkam.theme.R.font.airbnb_cereal_app_book)),
            ),
            singleLine = true
        )
    }
}

@Composable
fun EmailSection() {
    Column(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = "Email Address",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
        )

        val bringIntoViewRequester = remember { BringIntoViewRequester() }
        val coroutineScope = rememberCoroutineScope()

        val focusRequester = remember { FocusRequester() }
        var email by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            isError = false,
            shape = RoundedCornerShape(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.onBackground,
                unfocusedContainerColor = MaterialTheme.colorScheme.onBackground,
                errorContainerColor = MaterialTheme.colorScheme.onBackground,
                cursorColor = Color(0xFFCCCCCC),
                errorBorderColor = Color(0xFFDB0F4E),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = Color(0xFF3C4043),
                unfocusedTextColor = Color(0xFF3C4043),
                errorTextColor = Color(0xFFDB0F4E)
            ),
            modifier = Modifier
                .height(54.dp)
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .bringIntoViewRequester(bringIntoViewRequester)
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        coroutineScope.launch {
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Font(com.mkam.theme.R.font.airbnb_cereal_app_book)),
            ),
            singleLine = true
        )
    }
}

@Composable
fun PasswordSection() {
    Column(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(
            text = "Password",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
        )

        val bringIntoViewRequester = remember { BringIntoViewRequester() }
        val coroutineScope = rememberCoroutineScope()

        val focusRequester = remember { FocusRequester() }
        var password by rememberSaveable { mutableStateOf("") }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            isError = false,
            shape = RoundedCornerShape(50.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.onBackground,
                unfocusedContainerColor = MaterialTheme.colorScheme.onBackground,
                errorContainerColor = MaterialTheme.colorScheme.onBackground,
                cursorColor = Color(0xFFCCCCCC),
                errorBorderColor = Color(0xFFDB0F4E),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = Color(0xFF3C4043),
                unfocusedTextColor = Color(0xFF3C4043),
                errorTextColor = Color(0xFFDB0F4E)
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            trailingIcon = {
                val image = if (passwordVisible) R.drawable.eye_password_hide
                else R.drawable.eye_password_show
                val description = if (passwordVisible) "Hide password" else "Show password"
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        tint = MaterialTheme.colorScheme.primary,
                        painter = painterResource(image),
                        contentDescription = description
                    )
                }
            },
            modifier = Modifier
                .height(54.dp)
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .bringIntoViewRequester(bringIntoViewRequester)
                .onFocusChanged { focusState ->
                    if (focusState.isFocused) {
                        coroutineScope.launch {
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Font(com.mkam.theme.R.font.airbnb_cereal_app_book)),
            ),
            singleLine = true
        )
    }
}