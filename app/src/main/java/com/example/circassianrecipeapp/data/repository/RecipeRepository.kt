package com.example.circassianrecipeapp.data.repository

import android.app.Application
import androidx.room.Room
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.data.dao.RecipeDao
import com.example.circassianrecipeapp.data.database.entity.Recipe
import com.example.circassianrecipeapp.di.DatabaseModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    application: Application,
    private val recipeDao: RecipeDao
) {
    private val database = Room.databaseBuilder(
        application,
        DatabaseModule::class.java,
        "circassian_recipe_database"
    ).fallbackToDestructiveMigration().build()

    init {
        insertInitialRecipes()
    }

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

    suspend fun getRecipes(name: String, category: String): Flow<List<Recipe>> {
        return recipeDao.getRecipes(name, category)
    }

    suspend fun getRecipeById(recipeId: Int): Flow<Recipe?> {
        return recipeDao.getRecipeById(recipeId)
    }

    suspend fun getRecipesByCategory(category: String): Flow<List<Recipe>> {
        return recipeDao.getRecipesByCategory(category)
    }

    suspend fun getFavoriteRecipes(): Flow<List<Recipe>> {
        return recipeDao.getFavoriteRecipes(true)
    }

}
