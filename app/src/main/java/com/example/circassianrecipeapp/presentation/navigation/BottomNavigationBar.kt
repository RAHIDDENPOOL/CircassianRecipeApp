package com.example.circassianrecipeapp.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.circassianrecipeapp.presentation.theme.CircassianRecipeAppTheme

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
    CircassianRecipeAppTheme {
        Column {
            BottomAppBar(
                modifier = Modifier.navigationBarsPadding()
            ) {
                val navBackStackEntry by navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                items.forEach { items ->
                    NavigationBarItem(
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
                        icon = { Icon(items.unSelectedIcon, contentDescription = items.title) },
                        label = { Text(text = items.title) },
                        selected = items.route == currentRoute
                    )
                }
            }
        }
    }
}
