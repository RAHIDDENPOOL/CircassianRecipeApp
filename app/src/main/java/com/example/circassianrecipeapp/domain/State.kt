package com.example.circassianrecipeapp.domain

import com.example.circassianrecipeapp.data.entity.Recipe
import kotlinx.coroutines.flow.Flow

sealed class State<T> {
    data class Content<T>(
        val selectedRecipe: Recipe?,
        val recipes: Flow<List<Recipe>>? = null
    ) : State<T>()

    data class Loading<T>(val isLoading: Boolean) : State<T>()
    data class Error<T>(val errorMessage: String) : State<T>()
    //TODO(Error logger for BaseViewModel and over spots)
}

