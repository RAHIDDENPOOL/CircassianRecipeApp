package com.example.circassianrecipeapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.circassianrecipeapp.data.entity.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes")
    fun getAllRecipes(): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes where id = :recipeId ")
    fun getRecipeById(recipeId: Int): Recipe

    @Query("SELECT * FROM recipes WHERE category = :category ORDER BY category ASC")
    fun getRecipesByCategory(category: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE category = :title ORDER BY title ASC")
    fun getRecipesByTitle(title: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE isFavorite = :isFavorite")
    fun getFavoriteRecipes(isFavorite: Boolean): Flow<List<Recipe>>

    @Query("UPDATE recipes SET isFavorite = :isFavorite WHERE id = :recipeId")
    suspend fun addToFavorite(recipeId: Int, isFavorite: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: Recipe)
}
