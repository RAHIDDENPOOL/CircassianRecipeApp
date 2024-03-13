package com.example.circassianrecipeapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigationBar(navHostController: NavHostController) {
    val items = listOf(
        BottomNavigationItemModel(
            route = Route.RECIPESSCREEN,
            title = "Рецепты",
            selectedIcon = Icons.Default.Menu,
            unSelectedIcon = Icons.Default.Menu,
        ),
        BottomNavigationItemModel(
            route = Route.FAVORITESSCREEN,
            title = "Избранные",
            selectedIcon = Icons.Default.FavoriteBorder,
            unSelectedIcon = Icons.Default.FavoriteBorder,
        ),
        BottomNavigationItemModel(
            route = Route.COOKINGSSCREEN,
            title = "Готовка",
            selectedIcon = Icons.Default.Info,
            unSelectedIcon = Icons.Default.Info,
        ),
    )

    Column {
        BottomNavigation {
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { items ->
                BottomNavigationItem(
                    onClick = {
                        if (items.route != currentRoute) {
                            when (items.route) {
                                Route.RECIPESSCREEN -> {
                                    navHostController.navigate(items.route)
                                }

                                Route.FAVORITESSCREEN -> {
                                    navHostController.navigate(items.route)
                                }

                                Route.COOKINGSSCREEN -> {
                                    navHostController.navigate(items.route)
                                }
                            }
                        }
                    },
                    icon = { Icon(items.unSelectedIcon, "") },
                    label = { Text(text = items.title) },
                    selected = items.route == currentRoute
                )
            }
        }
    }
}
