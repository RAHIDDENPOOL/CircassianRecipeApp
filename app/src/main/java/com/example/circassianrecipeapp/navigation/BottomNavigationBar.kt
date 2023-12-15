package com.example.circassianrecipeapp.navigation

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
import com.example.circassianrecipeapp.ui.screens.cooking.CookingScreen
import com.example.circassianrecipeapp.ui.screens.favorites.FavoritesScreen
import com.example.circassianrecipeapp.ui.screens.recipes.RecipesScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavigationItem(
            route = Route.RecipesScreen,
            title = "Рецепты",
            selectedIcon = Icons.Default.List,
            unSelectedIcon = Icons.Default.List,
        ),
        BottomNavigationItem(
            route = Route.Favorites,
            title = "Избранные",
            selectedIcon = Icons.Default.FavoriteBorder,
            unSelectedIcon = Icons.Default.FavoriteBorder,
        ),
        BottomNavigationItem(
            route = Route.Cooking,
            title = "Готовка",
            selectedIcon = Icons.Default.Info,
            unSelectedIcon = Icons.Default.Info,
        ),
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
                                imageVector = item.selectedIcon.takeIf { item.route == backStackEntry.value?.destination?.route }
                                    ?: item.unSelectedIcon,
                                contentDescription = item.title,
                            )
                        },
                    )
                }
            }
        },
        content = {
            when (backStackEntry.value?.destination?.route) {
                Route.RecipesScreen -> {
                    RecipesScreen(navController = navController)
                }

                Route.Favorites -> {
                    FavoritesScreen()
                }

                Route.Cooking -> {
                    CookingScreen()
                }

                else -> {
                    RecipesScreen(navController = navController) // TODO -> Обработка неизвестного маршрута = экран по дефолту
                }
            }
        },
    )
}
