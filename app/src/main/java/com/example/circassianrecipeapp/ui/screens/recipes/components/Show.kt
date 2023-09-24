package com.example.circassianrecipeapp.ui.screens.recipes.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.ui.screens.recipes.RecipesScreen

@Composable
fun Show() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val imageId = arrayOf(
            R.drawable.carousel_first_item,
             //R.drawable.p2,
             //R.drawable.p3,
             //R.drawable.p4,
             //R.drawable.p5,
             //R.drawable.p6
        )

        val names = arrayOf(
            "Peperoni",
            "Vegan",
            "FourCheese",
            "Margaritta",
            "American",
            "Mexican"
        )

        val ingredients = arrayOf(
            "Tomato sos, cheese, oregano, peperoni",
            "Tomato sos, cheese, oregano, spinach, green paprika, rukola",
            "Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
            "Tomato sos, cheese, oregano, bazillion",
            "Tomato sos, cheese, oregano, green paprika, red beans",
            "Tomato sos, cheese, oregano, corn, jalapeno, chicken",
        )

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "RecipesScreen") {
            composable(route = "RecipesScreen") {
                RecipesScreen(imageId, names, ingredients, navController)
            }
            composable(route = "DetailScreen/{index}",
                arguments = listOf(
                    navArgument(name = "index") {
                        type = NavType.IntType
                    }
                )
            ) { index ->
                DetailScreen(
                    photos = imageId,
                    names = names,
                    ingredients = ingredients,
                    itemIndex = index.arguments?.getInt("index")
                )
            }
        }

    }
}