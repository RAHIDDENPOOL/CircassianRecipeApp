package com.example.circassianrecipeapp.presentation.screens.recipes

import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.entity.Recipe
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.domain.UserAction
import com.example.circassianrecipeapp.domain.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * RecipesViewModel будет держать в скоупе экран открытого рецепта
 * отдельный рецепт должен быть запущен на фрагменте
 * базовый экран запускаемый из MainActivity будет в скоупе BaseViewModel
 **/
@HiltViewModel
class RecipesViewModel @Inject constructor(
    recipeRepository: RecipeRepository
) : BaseViewModel(recipeRepository) {

    init {
        initRecipes()
    }

    private fun initRecipes() {
        viewModelScope.launch {
            handleIntent(UserAction.LoadRecipes)
        }
    }

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes

    fun addToFavorite(recipeId: Int, isFavorite: Boolean) {
        handleIntent(UserAction.AddToFavorite(recipeId, isFavorite))
    }

    fun openRecipe(recipeId: Int) {
        handleIntent(UserAction.OpenRecipe(recipeId))
    }

    suspend fun onStateUpdated(newUserState: UserState<List<Recipe>>) {
        when (newUserState) {
            is UserState.RecipesList -> {
                _recipes.value
            }

            is UserState.Loading -> {
                // Handle loading state if needed
            }

            is UserState.Error -> {
                // Handle error state if needed
            }

            is UserState.SelectedContent -> TODO()
        }
    }
}
