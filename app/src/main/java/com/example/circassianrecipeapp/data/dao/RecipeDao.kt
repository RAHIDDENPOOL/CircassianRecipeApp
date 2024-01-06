package com.example.circassianrecipeapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.circassianrecipeapp.data.database.entity.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipes")
    fun getRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    fun getRecipeById(recipeId: Long): Flow<Recipe?>

    @Query("SELECT * FROM recipes ORDER BY :category")
    fun getRecipesByCategory(category: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE isFavorite = :isFavorite")
    fun getFavoriteRecipes(isFavorite: Boolean): Flow<List<Recipe>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: Recipe)
}
