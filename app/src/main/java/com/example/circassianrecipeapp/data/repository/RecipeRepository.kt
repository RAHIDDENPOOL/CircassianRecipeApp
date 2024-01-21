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
        }
    }

    fun getAllRecipes(
    ): Flow<List<Recipe>> {
        return recipeDao.getAllRecipes("", "", "", 0, 0)
    }

    fun getRecipeById(
        recipeId: Int, imageId: Int, tittle: String, label: String, description:
        String, ingredients: String, instructions: String
    ): Flow<Recipe?> {
        return recipeDao.getRecipeById(
            recipeId, imageId, tittle, label,
            description, ingredients, instructions
        )
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
