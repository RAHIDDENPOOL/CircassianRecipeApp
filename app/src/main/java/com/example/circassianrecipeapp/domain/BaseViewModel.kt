package com.example.circassianrecipeapp.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.dao.RecipeDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class BaseViewModel(private val recipeDao: RecipeDao) : ViewModel() {

    fun handleEvent(event: Event) {
        when (event) {
            is Event.AddToFavorite -> handleAddToFavorite(event)

            is Event.OpenRecipe -> handleOpenRecipe(event)

            is Event.SearchRecipe -> handleSearchRecipe(event)
        }
    }

    private fun handleAddToFavorite(event: Event.AddToFavorite) {
        viewModelScope.launch {
            // Implement your logic for adding to favorites
            // recipeDao.updateFavoriteStatus(event.recipeId, true)
        }
    }

    private fun handleOpenRecipe(event: Event.OpenRecipe) {
        viewModelScope.launch {
            recipeDao.getRecipeById(event.recipeId)
        }
    }

    private fun handleSearchRecipe(event: Event.SearchRecipe) {
        viewModelScope.launch {
            recipeDao.getRecipes(event.name, event.category)
        }
    }
}
