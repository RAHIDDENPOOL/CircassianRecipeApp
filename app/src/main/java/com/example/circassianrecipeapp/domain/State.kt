package com.example.circassianrecipeapp.domain

import com.example.circassianrecipeapp.data.database.entity.Recipe
import kotlinx.coroutines.flow.Flow

sealed class State {
    data class Content(
        val selectedRecipe: Recipe?,
        val recipes: Flow<List<Recipe>>? = null
    ) : State()

    data class Loading(val isLoading: Boolean) : State()
    data class Error(val errorMessage: String) : State()
    //TODO(Error logger for BaseViewModel and over spots)
}

