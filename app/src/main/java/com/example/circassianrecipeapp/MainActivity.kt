package com.example.circassianrecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.circassianrecipeapp.ui.navigation.BottomNavigationBar
import com.example.circassianrecipeapp.view.theme.CircassianRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircassianRecipeAppTheme {
                BottomNavigationBar()
            }
        }
    }
}