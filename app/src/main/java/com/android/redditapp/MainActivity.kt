package com.android.redditapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.redditapp.presentation.home_screen.AppContent
import com.android.redditapp.ui.theme.RedditAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedditAppTheme {
                AppContent()
            }
        }
    }
}




