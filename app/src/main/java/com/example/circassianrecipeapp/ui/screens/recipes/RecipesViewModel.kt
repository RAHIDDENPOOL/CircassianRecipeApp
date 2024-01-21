package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
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
            recipeRepository.insertInitialRecipes()
        }
    }

    val recipes: MutableState<List<Recipe>> = mutableStateOf(emptyList())
    fun getAllRecipes(): Flow<List<Recipe>> {
        return recipeRepository.getAllRecipes()
    }

    fun addToFavorite(recipeId: Int, isFavorite: Boolean) {
        handleEvent(Event.AddToFavorite(recipeId, isFavorite))
    }

    fun openRecipe(
        recipeId: Int,
        imageId: Int,
        title: String,
        label: String,
        description: String,
        ingredients: String,
        instructions: String
    ) {
        handleEvent(
            Event.OpenRecipe(
                recipeId, imageId, title, label, description, ingredients, instructions
            )
        )
    }

}
