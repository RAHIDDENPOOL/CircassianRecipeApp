package com.example.circassianrecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.circassianrecipeapp.ui.navigation.BottomNavigationBar
import com.example.circassianrecipeapp.ui.screens.recipes.components.DetailScreen
import com.example.circassianrecipeapp.view.theme.CircassianRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircassianRecipeAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "RecipesScreen",
                ) {
                    composable("RecipesScreen") {
                        BottomNavigationBar(navController)
                    }
                    composable(
                        "DetailScreen/{index}",
                        arguments = listOf(
                            navArgument(name = "index") {
                                type = NavType.IntType
                            },
                        ),
                    ) { backStackEntry ->
                        val index = backStackEntry.arguments?.getInt("index")
                        if (index != null) {
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
                            navController.navigate("RecipesScreen")
                        }
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
