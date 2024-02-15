package com.example.circassianrecipeapp.domain

sealed class UserAction {
    data object LoadRecipes : UserAction()
    data class AddToFavorite(val recipeId: Int, val isFavorite: Boolean) : UserAction()
    data class SearchRecipe(val title: String, val category: String) : UserAction()
    data class OpenRecipe(val recipeId: Int) : UserAction()
}