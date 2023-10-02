package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.circassianrecipeapp.ui.navigation.TopAppBar
import com.example.circassianrecipeapp.ui.screens.recipes.components.Carousel
import com.example.circassianrecipeapp.ui.screens.recipes.components.RecipeNavigation

@Composable
fun RecipesScreen() {
    TopAppBar()
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 55.dp),
    ) {
        Carousel()
        RecipeNavigation()
    }
}
