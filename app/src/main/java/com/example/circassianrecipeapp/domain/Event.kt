package com.example.circassianrecipeapp.domain

import com.example.circassianrecipeapp.data.database.entity.Recipe

sealed interface Event {
    data class OpenRecipe(val recipeId: Recipe) : Event
    data class AddToFavorite(val recipeId: Recipe) : Event
    data class SearchRecipe(val name: Recipe, val category: Recipe) : Event
}