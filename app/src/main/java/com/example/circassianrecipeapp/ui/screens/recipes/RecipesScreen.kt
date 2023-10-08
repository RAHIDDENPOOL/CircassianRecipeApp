package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.ui.navigation.TopAppBar
import com.example.circassianrecipeapp.ui.screens.recipes.components.Carousel
import com.example.circassianrecipeapp.ui.screens.recipes.components.RecipeCardsColumn

@Composable
fun RecipesScreen(navController: NavController) {
    MaterialTheme {
        TopAppBar()
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 55.dp),

        ) {
            Carousel()

            val imageId = arrayOf(
                R.drawable.dish_one,
                R.drawable.dish_two,
                R.drawable.dish_one,
                R.drawable.dish_two,
                R.drawable.dish_one,
                R.drawable.dish_two,
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

            val description = arrayOf(
                "Circassian sos, cheese, oregano, peperoni",
                "Circassian sos, cheese, oregano, spinach, green paprika, rukola",
                "Circassian sos, oregano, mozzarella, goda, parmesan, cheddar",
                "Circassian sos, cheese, oregano, bazillion",
                "Circassian sos, cheese, oregano, green paprika, red beans",
                "Circassian sos, cheese, oregano, corn, jalapeno, chicken",
            )

            RecipeCardsColumn(
                imageId = imageId,
                names = names,
                subhead = ingredients,
                description = description,
                navController = navController,
            )
        }
    }
}
