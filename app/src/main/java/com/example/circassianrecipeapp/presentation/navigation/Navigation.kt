package com.example.circassianrecipeapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.presentation.screens.cooking.CookingScreen
import com.example.circassianrecipeapp.presentation.screens.favorites.FavoritesScreen
import com.example.circassianrecipeapp.presentation.screens.recipes.RecipesScreen
import com.example.circassianrecipeapp.presentation.screens.recipes.components.DetailsScreen
import com.example.circassianrecipeapp.presentation.screens.search.SearchScreen
import com.example.circassianrecipeapp.presentation.screens.settings.SettingsScreen

@Composable
fun Navigation(navController: NavHostController, viewModel: BaseViewModel) {
    NavHost(navController, startDestination = Route.RECIPESSCREEN) {

        composable(Route.RECIPESSCREEN) {
            RecipesScreen(navController, viewModel)
        }
        composable(Route.FAVORITESSCREEN) {
            FavoritesScreen()
        }
        composable(Route.COOKINGSSCREEN) {
            CookingScreen()
        }
        composable(
            route = "${Route.DETAILSSCREEN}/{recipeId}",
            arguments = listOf(navArgument("recipeId") { type = NavType.IntType })
        ) { backStackEntry ->
            DetailsScreen()
        }

        composable(Route.SEARCHSCREEN) {
            SearchScreen()
        }
        composable(Route.SETTINGSSCREEN) {
            SettingsScreen()
        }
    }
}