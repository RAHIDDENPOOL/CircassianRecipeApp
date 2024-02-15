package com.example.circassianrecipeapp.domain

import com.example.circassianrecipeapp.data.entity.Recipe
import kotlinx.coroutines.flow.Flow

sealed class UserState<T> {
    data class ListContent<T>(val recipes: Flow<List<Recipe>>) : UserState<T>()
    data class SelectedContent<T>(val selectedRecipe: Recipe) : UserState<T>()
    data class Loading<T>(val isLoading: Boolean) : UserState<T>()
    data class Error<T>(val errorMessage: String) : UserState<T>()
}
