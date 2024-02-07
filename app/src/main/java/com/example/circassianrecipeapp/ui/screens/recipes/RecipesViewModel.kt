package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.entity.Recipe
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.domain.Intent
import com.example.circassianrecipeapp.domain.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    recipeRepository: RecipeRepository
) : BaseViewModel(recipeRepository) {

    init {
        viewModelScope.launch {
            recipeRepository.insertInitialRecipes()
        }
    }

    private val _recipes = mutableStateOf<List<Recipe>>(emptyList())
    val recipes: MutableState<List<Recipe>> = _recipes

    fun getAllRecipes() {
        handleIntent(Intent.LoadRecipes)
    }

    fun addToFavorite(recipeId: Int, isFavorite: Boolean) {
        handleIntent(Intent.AddToFavorite(recipeId, isFavorite))
    }

    fun openRecipe(recipeId: Int) {
        handleIntent(Intent.OpenRecipe(recipeId))
    }

    override suspend fun onStateUpdated(newState: State<List<Recipe>>) {
        when (newState) {
            is State.Content -> {
                _recipes.value = (newState.recipes?.toList()?.flatten() ?: emptyList())
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
