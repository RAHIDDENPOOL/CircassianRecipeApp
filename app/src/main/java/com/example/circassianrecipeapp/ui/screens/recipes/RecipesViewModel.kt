package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.database.entity.Recipe
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import com.example.circassianrecipeapp.domain.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
    val recipes: State<List<Recipe>> = _recipes

    fun getAllRecipes() {
        viewModelScope.launch {
            recipeRepository.getAllRecipes().collect { recipes ->
                _recipes.value = recipes
                println("Recipes in getAllRecipes(): $recipes")
                println("Number of recipes: ${recipes.size}")
            }
        }
    }

    fun addToFavorite(recipeId: Int, isFavorite: Boolean) {
        handleIntent(Event.AddToFavorite(recipeId, isFavorite))
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
        handleIntent(
            Event.OpenRecipe(
                recipeId, imageId, title, label, description, ingredients, instructions
            )
        )
    }

}
