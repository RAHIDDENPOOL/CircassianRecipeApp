package com.example.circassianrecipeapp.domain

import androidx.lifecycle.ViewModel
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    val state: MutableStateFlow<State> = recipeRepository.state as MutableStateFlow<State>

    private val viewModelScope = CoroutineScope(Dispatchers.Default)

    fun handleEvent(event: Event) {
        viewModelScope.launch {
            when (event) {
                is Event.AddToFavorite -> handleAddToFavorite(event)

                is Event.OpenRecipe -> handleOpenRecipe(event)

                is Event.SearchRecipe -> handleSearchRecipe(event)
            }
        }
    }

    private suspend fun handleAddToFavorite(event: Event.AddToFavorite) {
        recipeRepository.addToFavorite(event.recipeId)
        state.emit(state.value.copy(favoriteRecipes = recipeRepository.getFavoriteRecipes()))
    }

    private suspend fun handleOpenRecipe(event: Event.OpenRecipe) {
        val recipe = recipeRepository.getRecipeById(event.recipeId)
        state.emit(state.value.copy(selectedRecipe = recipe))
    }

    private suspend fun handleSearchRecipe(event: Event.SearchRecipe) {
        val recipes = recipeRepository.getRecipes(event.name, event.category)
        state.emit(state.value.copy(recipes = recipes))
    }
}
