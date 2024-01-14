package com.example.circassianrecipeapp.domain

sealed interface Event {
    data class OpenRecipe(
        val recipeId: Int, val imageId: Int, val tittle: String, val label: String, val description:
        String, val ingredients: String, val instructions: String
    ) : Event

    data class AddToFavorite(val recipeId: Int, val isFavorite: Boolean) : Event
    data class SearchRecipe(
        val tittle: String,
        val category: String,
    ) : Event
}