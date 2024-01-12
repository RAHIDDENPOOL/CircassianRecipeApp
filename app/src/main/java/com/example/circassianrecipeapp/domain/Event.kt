package com.example.circassianrecipeapp.domain

sealed interface Event {
    data class OpenRecipe(val recipeId: Int) : Event
    data class AddToFavorite(val recipeId: Int) : Event
    data class SearchRecipe(val name: String, val category: String) : Event
}