package com.example.circassianrecipeapp.domain

sealed class Intent {
    data object LoadRecipes : Intent()
    data class AddToFavorite(val recipeId: Int, val isFavorite: Boolean) : Intent()
    data class SearchRecipe(val tittle: String, val category: String) : Intent()
    data class OpenRecipe(val recipeId: Int) : Intent()
}