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
            try {
                val recipeFile = context.assets.list("recipes") ?: emptyArray()
                for (recipeFileName in recipeFile) {
                    try {
                        val json = context.assets.open("recipes/$recipeFileName").bufferedReader()
                            .use { it.readText() }
                        val recipe = Gson().fromJson(json, Recipe::class.java)
                        recipeDao.insert(recipe)
                        Log.d("RecipeRepo", "Inserted recipe: ${recipe.title}")
                    } catch (e: IOException) {
                        Log.e(
                            "RecipeRepo",
                            "Error reading or inserting JSON file: $recipeFileName, $e"
                        )
                    } catch (e: JsonParseException) {
                        Log.e("RecipeRepo", "Error parsing JSON for file: $recipeFileName, $e")
                    }
                }
            } catch (e: IOException) {
                Log.e("RecipeRepo", "Error listing JSON files: $e")
            }
        }
    }

    fun getAllRecipes(): Flow<List<Recipe>> {
        return recipeDao.getAllRecipes()
            .catch { exception ->
                Log.e("RecipeRepository", "Error getting recipes: $exception")
            }
            .onStart {
                Log.d("RecipeRepository", "Start getting recipes")
            }
            .onCompletion {
                Log.d("RecipeRepository", "Completed getting recipes")
            }
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
