package com.example.circassianrecipeapp.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.circassianrecipeapp.data.database.entity.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipes")
    fun getRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    fun getRecipeById(recipeId: Long): Flow<Recipe?>

    @Upsert
    suspend fun upsertRecipe(recipe: Recipe)

    // TODO getRecipesByCategory(category: String): Flow<List<Recipe>>

}