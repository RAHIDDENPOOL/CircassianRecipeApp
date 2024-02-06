package com.example.circassianrecipeapp.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
    protected val recipeRepository: RecipeRepository
) : ViewModel() {
    val state: MutableStateFlow<State> = MutableStateFlow(State.Content(selectedRecipe = null))

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
        recipeRepository.insertInitialRecipes()
        //TODO(Loading effect)
        state.value = State.Loading(isLoading = true)
        state.value = State.Loading(isLoading = false)
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
            val recipes = if (intent.category.isNotEmpty()) {
                recipeRepository.getRecipesByCategory(intent.category)
            } else {
                recipeRepository.getRecipesByTittle(intent.tittle)
            }
            state.value = State.Content(selectedRecipe = null, recipes = recipes)
        }
    }
}
