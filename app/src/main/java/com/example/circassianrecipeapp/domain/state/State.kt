package com.example.circassianrecipeapp.domain.state

data class State(
    val isLoading: Boolean = false,
    val recipeIsReady: Int, // TODO get Recipes List + RecipeCard
    val error: String? = null,
) : UiState