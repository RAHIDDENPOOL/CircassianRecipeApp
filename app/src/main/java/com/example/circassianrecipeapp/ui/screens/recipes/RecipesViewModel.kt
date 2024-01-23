package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.circassianrecipeapp.data.database.entity.Recipe
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.domain.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
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
