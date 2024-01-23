package com.example.circassianrecipeapp.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
    protected val recipeRepository: RecipeRepository
) : ViewModel() {
    val state: MutableStateFlow<State> = MutableStateFlow(State(selectedRecipe = flowOf(null)))

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
        recipeRepository.addToFavorite(event.recipeId, event.isFavorite)
        state.value = state.value.copy(favoriteRecipes = recipeRepository.getFavoriteRecipes())
    }

    private fun handleOpenRecipe(event: Event.OpenRecipe) {
        val recipe = recipeRepository.getRecipeById(event.recipeId)
        state.value = state.value.copy(selectedRecipe = recipe)
    }

    private fun handleSearchRecipe(event: Event.SearchRecipe) {
        val recipes = if (event.category.isNotEmpty()) {
            recipeRepository.getRecipesByCategory(event.category)
        } else {
            recipeRepository.getRecipesByTittle(event.tittle)
        }
        state.value = state.value.copy(recipes = recipes)
    }
}
