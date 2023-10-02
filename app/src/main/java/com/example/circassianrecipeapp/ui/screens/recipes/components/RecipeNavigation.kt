package com.example.circassianrecipeapp.ui.screens.recipes.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.circassianrecipeapp.R

@Preview
@Composable
fun RecipeNavigation() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
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

        val listNavController = rememberNavController()
        NavHost(navController = listNavController, startDestination = "MainScreen") {
            composable(route = "MainScreen") {
                RecipeCardsColumn(imageId, names, ingredients, listNavController)
            }
            composable(
                "DetailScreen/{index}",
                arguments = listOf(
                    navArgument(name = "index") {
                        type = NavType.IntType
                    },
                ),
            ) { index ->
                DetailScreen(
                    photos = imageId,
                    names = names,
                    ingredients = ingredients,
                    itemIndex = index.arguments?.getInt("index"),
                )
            }
        }
    }
}
