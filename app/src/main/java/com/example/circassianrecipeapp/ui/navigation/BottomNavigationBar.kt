package com.example.circassianrecipeapp.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.circassianrecipeapp.data.models.BottomNavigationItem
import com.example.circassianrecipeapp.ui.screens.recipes.RecipesScreen
import com.example.circassianrecipeapp.ui.screens.cooking.CookingScreen
import com.example.circassianrecipeapp.ui.screens.favorites.FavoritesScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(navController: NavHostController) {

    val items = listOf(
        BottomNavigationItem(
            route = "Recipes",
            title = "Recipes",
            selectedIcon = Icons.Default.List,
            unSelectedIcon = Icons.Default.List
        ),
        BottomNavigationItem(
            route = "Favorites",
            title = "Favorites",
            selectedIcon = Icons.Default.FavoriteBorder,
            unSelectedIcon = Icons.Default.FavoriteBorder
        ),
        BottomNavigationItem(
            route = "Cooking",
            title = "Cooking",
            selectedIcon = Icons.Default.Info,
            unSelectedIcon = Icons.Default.Info
        )
    )

    val backStackEntry = navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { _, item ->
                    NavigationBarItem(
                        selected = item.route == backStackEntry.value?.destination?.route,
                        onClick = { navController.navigate(item.route) },
                        label = {
                            Text(text = item.title)
                        },
                        alwaysShowLabel = true,
                        icon = {
                            Icon(
                                imageVector = if (item.route == backStackEntry.value?.destination?.route) {
                                    item.selectedIcon
                                } else item.unSelectedIcon,
                                contentDescription = item.title
                            )
                        }
                    )
                }
            }
        },
        content = {
            when (backStackEntry.value?.destination?.route) {
                "Recipes" -> RecipesScreen()
                "Favorites" -> FavoritesScreen()
                "Cooking" -> CookingScreen()
                else -> {
                    RecipesScreen() //TODO -> Обработка неизвестного маршрута = экран по дефолту
                }
            }
        }
    )
}