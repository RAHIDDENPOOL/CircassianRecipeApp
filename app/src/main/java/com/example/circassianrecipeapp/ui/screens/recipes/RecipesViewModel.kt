package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.dao.RecipeDao
import com.example.circassianrecipeapp.data.database.entity.Recipe
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.domain.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
    recipeRepository: RecipeRepository
) : BaseViewModel(recipeRepository) {

    init {
        viewModelScope.launch {
            recipeRepository.state.collect {
                state.emit(it)
            }
        }
    }

    val recipes: Flow<List<Recipe>> = recipeRepository.getRecipes("", "")

    fun addToFavorite(recipeId: Int) {
        handleEvent(Event.AddToFavorite(recipeId))
    }

    fun openRecipe(recipeId: Int) {
        handleEvent(Event.OpenRecipe(recipeId))
    }

    fun searchRecipe(name: String, category: String) {
        handleEvent(Event.SearchRecipe(name, category))
    }
}
