package com.example.circassianrecipeapp.data.repository

import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.data.dao.RecipeDao
import com.example.circassianrecipeapp.data.database.entity.Recipe
import com.example.circassianrecipeapp.domain.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeRepository @Inject constructor(
    private val recipeDao: RecipeDao
) {
    private val _state = MutableStateFlow(State())
    val state: StateFlow<State>
        get() = _state

    private fun insertInitialRecipes() {
        CoroutineScope(Dispatchers.Default).launch {
            val recipes = listOf(
                Recipe(
                    imageId = R.drawable.dish_one,
                    name = "Recipe 1",
                    category = "Category 1",
                    ingredients = "Ingredient 1",
                    instructions = "Instructions 1",
                    isFavorite = false
                ),
                Recipe(
                    imageId = R.drawable.dish_two,
                    name = "Recipe 2",
                    category = "Category 2",
                    ingredients = "Ingredient 2",
                    instructions = "Instructions 2",
                    isFavorite = false
                ),
                // Добавляем сюда все рецепты
            )
            for (recipe in recipes) {
                recipeDao.insert(recipe)
            }
        }
    }

    fun getRecipes(name: String, category: String): Flow<List<Recipe>> {
        return recipeDao.getRecipes(name, category)
    }

    fun getRecipeById(recipeId: Int): Flow<Recipe?> {
        return recipeDao.getRecipeById(recipeId)
    }

    suspend fun addToFavorite(recipeId: Int) {
        val recipe = recipeDao.getRecipeById(recipeId).firstOrNull()
        recipe?.let {
            it.isFavorite = true
            recipeDao.insert(it)
        }
    }

    fun getRecipesByCategory(category: String): Flow<List<Recipe>> {
        return recipeDao.getRecipesByCategory(category)
    }

    fun getFavoriteRecipes(): Flow<List<Recipe>> {
        return recipeDao.getFavoriteRecipes(true)
    }

}
