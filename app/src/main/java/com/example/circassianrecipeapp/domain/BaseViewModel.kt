package com.example.circassianrecipeapp.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.entity.Recipe
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {
    private val userState: MutableStateFlow<UserState<List<Recipe>>>
        get() = MutableStateFlow(UserState.Loading(isLoading = true))


    fun handleIntent(userAction: UserAction) {
        viewModelScope.launch {
            when (userAction) {
                is UserAction.AddToFavorite -> handleAddToFavorite(userAction)

                is UserAction.LoadRecipes -> loadRecipes()

                is UserAction.OpenRecipe -> handleOpenRecipe(userAction.recipeId)

                is UserAction.SearchRecipe -> handleSearchRecipe(userAction)
            }
        }
    }

     private fun loadRecipes() {
        viewModelScope.launch {
            try {
                userState.value = UserState.Loading(isLoading = true)
                val recipesList = recipeRepository.getAllRecipes()
                userState.value = UserState.ListContent(recipes = recipesList)
            } catch (e: Exception) {
                userState.value =
                    UserState.Error(errorMessage = "Error getting recipes: ${e.message}")
            }
        }
    }


    private suspend fun handleAddToFavorite(userAction: UserAction.AddToFavorite) {
        recipeRepository.addToFavorite(userAction.recipeId, userAction.isFavorite)
        loadRecipes()
    }


    private fun handleOpenRecipe(recipeId: Int) {
        val recipe = recipeRepository.getRecipeById(recipeId)
        userState.value = UserState.SelectedContent(selectedRecipe = recipe)
    }

    private fun handleSearchRecipe(userAction: UserAction.SearchRecipe) {
        viewModelScope.launch {
            val recipesFlow = if (userAction.category.isNotEmpty()) {
                recipeRepository.getRecipesByCategory(userAction.category)
            } else {
                recipeRepository.getRecipesByTitle(userAction.title)
            }
            userState.value = UserState.ListContent(recipes = recipesFlow)
        }
    }

}
