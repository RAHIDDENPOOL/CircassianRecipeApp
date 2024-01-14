package com.example.circassianrecipeapp.domain

import com.example.circassianrecipeapp.data.database.entity.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class State(
    val selectedRecipe: Flow<Recipe?>? = null,
    val recipes: Flow<List<Recipe>>? = null,
    val favoriteRecipes: Flow<List<Recipe>>? = null
)
