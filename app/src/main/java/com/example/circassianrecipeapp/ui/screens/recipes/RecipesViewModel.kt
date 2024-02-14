package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.entity.Recipe
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.domain.Intent
import com.example.circassianrecipeapp.domain.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    recipeRepository: RecipeRepository
) : BaseViewModel(recipeRepository) {
    init {
        initRecipes()
    }

    private fun initRecipes() {
        viewModelScope.launch {
            handleIntent(Intent.LoadRecipes)
        }
    }

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes

    fun addToFavorite(recipeId: Int, isFavorite: Boolean) {
        handleIntent(Intent.AddToFavorite(recipeId, isFavorite))
    }

    fun openRecipe(recipeId: Int) {
        handleIntent(Intent.OpenRecipe(recipeId))
    }

    override suspend fun onStateUpdated(newState: State<List<Recipe>>) {
        when (newState) {
            is State.Content -> {
                _recipes.value = newState.recipes?.toList()?.flatten() ?: emptyList()
            }

            is State.Loading -> {
                // Handle loading state if needed
            }

            is State.Error -> {
                // Handle error state if needed
            }
        }
    }
}
