package com.example.circassianrecipeapp.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.dao.RecipeDao
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaseViewModel @Inject constructor(
    private val recipeDao: RecipeDao,
    private val recipeRepository: RecipeRepository

) : ViewModel() {
    private val _state = MutableStateFlow(State())

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
        viewModelScope.launch {
            recipeRepository.addToFavorite(event.recipeId)
            _state.emit(_state.value.copy(favoriteRecipes = recipeRepository.getFavoriteRecipes()))
        }
    }

    private suspend fun handleOpenRecipe(event: Event.OpenRecipe) {
        viewModelScope.launch {
            val recipe = recipeRepository.getRecipeById(event.recipeId)
            _state.emit(_state.value.copy(selectedRecipe = recipe))
            recipeDao.getRecipeById(event.recipeId)
        }
    }

    private suspend fun handleSearchRecipe(event: Event.SearchRecipe) {
        viewModelScope.launch {
            val recipes = recipeRepository.getRecipes(event.name, event.category)
            _state.emit(_state.value.copy(recipes = recipes))
            recipeDao.getRecipes(event.name, event.category)
        }
    }
}
