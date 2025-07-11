package com.mkam.stepup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mkam.presentation.CartScreen
import com.mkam.presentation.SettingsScreen
import com.mkam.presentation.ui.singin.SingInScreen
import com.mkam.theme.components.theme.StepUpTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StepUpTheme {
                SettingsScreen()
            }
        }
    }
}
