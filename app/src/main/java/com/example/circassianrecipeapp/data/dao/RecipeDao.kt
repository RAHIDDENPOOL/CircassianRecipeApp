package com.example.circassianrecipeapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.circassianrecipeapp.data.database.entity.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipes WHERE name = :name AND category = :category")
    fun getRecipes(name: String, category: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    fun getRecipeById(recipeId: Int): Flow<Recipe?>

    @Query("SELECT * FROM recipes WHERE category = :category ORDER BY category ASC")
    fun getRecipesByCategory(category: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE isFavorite = :isFavorite")
    fun getFavoriteRecipes(isFavorite: Boolean): Flow<List<Recipe>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: Recipe)
}
