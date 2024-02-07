package com.example.circassianrecipeapp.data.repository

import android.util.Log
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.data.dao.RecipeDao
import com.example.circassianrecipeapp.data.entity.Recipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val recipeDao: RecipeDao
) {
    internal fun insertInitialRecipes() {
        CoroutineScope(Dispatchers.Default).launch {
            val recipes = listOf(
                Recipe(
                    imageId = R.drawable.dish_one,
                    tittle = "Черкесские медовые шарики",
                    category = "Сладости",
                    label = "Дисерт",
                    description = "Медовые шарики - блюдо черкесской кухни, которое умеет готовить каждая черкесская хозяйка",
                    ingredients = "Мёд, тесто",
                    instructions = "Берем мёд, берем тесто -> бац бац и готово",
                    isFavorite = false
                ),
                Recipe(
                    imageId = R.drawable.dish_two,
                    tittle = "Черкесская курицаи",
                    category = "На первое",
                    label = "Мясо",
                    description = "Курица по черкесски - блюдо черкесской кухни, которое умеет готовить каждая черкесская хозяйка",
                    ingredients = "Курица, соль, перец",
                    instructions = "Берем курочку, берем духову -> бац бац и готово",
                    isFavorite = false
                ),
                // Todo Добавляем сюда все рецепты
            )
            for (recipe in recipes) {
                recipeDao.insert(recipe)
            }
            Log.d("RecipeRepository", "insertInitialRecipes() completed successfully")
        }
    }

    fun getAllRecipes(): Flow<List<Recipe>> {
        return recipeDao.getAllRecipes("", "", "", 0, 0)
            .catch { exception ->
                Log.e("RecipeRepository", "Error getting recipes: $exception")
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

    fun getRecipesByTittle(tittle: String): Flow<List<Recipe>> {
        return recipeDao.getRecipesByTittle(tittle)
    }

}
