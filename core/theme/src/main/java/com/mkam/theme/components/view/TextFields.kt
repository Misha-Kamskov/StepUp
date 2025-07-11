package com.mkam.theme.components.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mkam.theme.R
import kotlinx.coroutines.launch


@Composable
fun InputSection(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
        )

        val bringIntoViewRequester = remember { BringIntoViewRequester() }
        val coroutineScope = rememberCoroutineScope()
        val focusRequester = remember { FocusRequester() }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            isError = isError,
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
            visualTransformation = when {
                isPassword && !passwordVisible -> PasswordVisualTransformation()
                else -> VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            trailingIcon = when {
                isPassword -> {
                    {
                        val image = if (passwordVisible) R.drawable.icon_password_hide
                        else R.drawable.icon_password_show
                        val description = if (passwordVisible) "Hide password" else "Show password"
                        IconButton(
                            modifier = Modifier.size(24.dp),
                            onClick = { passwordVisible = !passwordVisible }
                        ) {
                            Icon(
                                tint = MaterialTheme.colorScheme.primary,
                                painter = painterResource(image),
                                contentDescription = description
                            )
                        }
                    }
                }
                trailingIcon != null -> trailingIcon
                else -> null
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

        errorMessage?.takeIf { isError }?.let { message ->
            Text(
                text = message,
                color = Color(0xFFDB0F4E),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}