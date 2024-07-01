package com.example.circassianrecipeapp.data.repository

import android.content.Context
import android.util.Log
import com.example.circassianrecipeapp.data.dao.RecipeDao
import com.example.circassianrecipeapp.data.entity.Recipe
import com.google.gson.Gson
import com.google.gson.JsonParseException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val recipeDao: RecipeDao,
    private val context: Context
) {
    suspend fun insertRecipesFromJson() {
        withContext(Dispatchers.IO) {
            val recipeFile = context.assets.list("recipes")
            for (recipeFileName in recipeFile!!) {
                try {
                    val json = context.assets
                        .open("recipes/$recipeFileName")
                        .bufferedReader()
                        .use { it.readText() }
                    val recipe = Gson().fromJson(json, Recipe::class.java)
                    recipeDao.insert(recipe)
                } catch (e: IOException) {
                    Log.e(
                        "RecipeRepo",
                        "Error reading or inserting JSON file: $recipeFileName, $e"
                    )
                }
            }
        }
    }

    fun getAllRecipes(): Flow<List<Recipe>> {
        return recipeDao.getAllRecipes()
    }


    fun getRecipeById(recipeId: Int): Recipe {
        return recipeDao.getRecipeById(recipeId)
    }

    suspend fun addToFavorite(recipeId: Int, isFavorite: Boolean) {
        recipeDao.addToFavorite(recipeId, isFavorite)
    }

    fun getFavoriteRecipes(): Flow<List<Recipe>> {
        return recipeDao.getFavoriteRecipes(true)
    }

    // Todo(Методы для реализации SearchScreenViewModel)
    fun getRecipesByCategory(category: String): Flow<List<Recipe>> {
        return recipeDao.getRecipesByCategory(category)
    }

    fun getRecipesByTitle(title: String): Flow<List<Recipe>> {
        return recipeDao.getRecipesByTitle(title)
    }
}
