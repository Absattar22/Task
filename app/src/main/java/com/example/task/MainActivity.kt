package com.example.task

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task()
        }
    }
}

@Composable
fun Task() {
    val sharedPreferences = LocalContext.current.getSharedPreferences("login_prefs", Context.MODE_PRIVATE)
    var isLoggedIn by remember { mutableStateOf(sharedPreferences.getBoolean("isLoggedIn", false)) }

    if (isLoggedIn) {
        WelcomeScreen(sharedPreferences)
    } else {
        LoginScreen(sharedPreferences) {
            isLoggedIn = true
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Task()
}
