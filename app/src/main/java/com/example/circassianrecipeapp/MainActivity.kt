package com.example.circassianrecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.circassianrecipeapp.ui.navigation.BottomNavigationBar
import com.example.circassianrecipeapp.view.theme.CircassianRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircassianRecipeAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "Recipes",
                ) {
                    composable("Recipes") {
                        BottomNavigationBar(navController)
                    }
                    composable("Favorites") {
                        BottomNavigationBar(navController)
                    }
                    composable("Cooking") {
                        BottomNavigationBar(navController)
                    }
                }
            }
        }
    }
}
