package com.example.circassianrecipeapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.circassianrecipeapp.navigation.BottomNavigationBar
import com.example.circassianrecipeapp.navigation.Route
import com.example.circassianrecipeapp.ui.screens.recipes.components.DetailScreen
import com.example.circassianrecipeapp.view.theme.CircassianRecipeAppTheme
/*
@Composable
fun MviApp() {
    CircassianRecipeAppTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.RecipesScreen,
        ) {
            composable(Route.RecipesScreen) {
                BottomNavigationBar(navController)
            }
            composable(
                "${Route.DetailScreen}/{index}",
                arguments = listOf(
                    navArgument(name = "index") {
                        type = NavType.IntType
                    },
                ),
            ) { backStackEntry ->
                val index = backStackEntry.arguments?.getInt("index")
                if (index != null) {
                    // Здесь должен быть метод getRecipes который передает список всех Recipes
                    val imageId = arrayOf(
                        R.drawable.carousel_first_item,
                        R.drawable.carousel_second_item,
                        R.drawable.carousel_first_item,
                        R.drawable.carousel_second_item,
                        R.drawable.carousel_first_item,
                        R.drawable.carousel_second_item,
                    )

                    val names = arrayOf(
                        "Peperoni",
                        "Vegan",
                        "FourCheese",
                        "Margaritta",
                        "American",
                        "Mexican",
                    )

                    val ingredients = arrayOf(
                        "Tomato sos, cheese, oregano, peperoni",
                        "Tomato sos, cheese, oregano, spinach, green paprika, rukola",
                        "Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
                        "Tomato sos, cheese, oregano, bazillion",
                        "Tomato sos, cheese, oregano, green paprika, red beans",
                        "Tomato sos, cheese, oregano, corn, jalapeno, chicken",
                    )

                    DetailScreen(
                        photos = imageId,
                        names = names,
                        ingredients = ingredients,
                        itemIndex = index,
                    )
                } else {
                    navController.popBackStack()
                }
            }
            composable(Route.Favorites) {
                BottomNavigationBar(navController)
            }
            composable(Route.Cooking) {
                BottomNavigationBar(navController)
            }
        }
    }
}*/