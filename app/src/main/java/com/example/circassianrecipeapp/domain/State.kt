package com.example.circassianrecipeapp.domain

import com.example.circassianrecipeapp.data.database.entity.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class State(
    val recipes: Flow<List<Recipe>> = flowOf(emptyList()),
    val favoriteRecipes: Flow<List<Recipe>> = flowOf(emptyList())
)