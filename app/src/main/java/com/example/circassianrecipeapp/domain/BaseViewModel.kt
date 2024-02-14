package com.example.circassianrecipeapp.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.entity.Recipe
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    private val state: MutableStateFlow<State<List<Recipe>>> =
        MutableStateFlow(State.Content(selectedRecipe = null))

    fun handleIntent(intent: Intent) {
        viewModelScope.launch {
            when (intent) {
                is Intent.AddToFavorite -> handleAddToFavorite(intent)

                is Intent.LoadRecipes -> loadRecipes()

                is Intent.OpenRecipe -> handleOpenRecipe(intent.recipeId)

                is Intent.SearchRecipe -> handleSearchRecipe(intent)
            }
        }
    }

    private fun loadRecipes() {
        viewModelScope.launch {
            val recipesFlow = recipeRepository.getAllRecipes()
            state.value = State.Loading(isLoading = true)
            try {
                recipesFlow.toList()
                state.value = State.Content(recipes = recipesFlow, selectedRecipe = null)
            } catch (e: Exception) {
                state.value = State.Error(errorMessage = "Error getting recipes: ${e.message}")
            }
        }
    }


    private suspend fun handleAddToFavorite(intent: Intent.AddToFavorite) {
        recipeRepository.addToFavorite(intent.recipeId, intent.isFavorite)
        state.value = State.Content(selectedRecipe = null)
    }

    private fun handleOpenRecipe(recipeId: Int) {
        val recipe = recipeRepository.getRecipeById(recipeId)
        state.value = State.Content(selectedRecipe = recipe)
    }

    private fun handleSearchRecipe(intent: Intent.SearchRecipe) {
        viewModelScope.launch {
            val recipesFlow = if (intent.category.isNotEmpty()) {
                recipeRepository.getRecipesByCategory(intent.category)
            } else {
                recipeRepository.getRecipesByTitle(intent.title)
            }
            state.value = State.Content(selectedRecipe = null, recipes = recipesFlow)
        }
    }

    open suspend fun onStateUpdated(newState: State<List<Recipe>>) {}
}
