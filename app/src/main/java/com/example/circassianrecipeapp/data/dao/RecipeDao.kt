package com.example.circassianrecipeapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.circassianrecipeapp.data.entity.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    //TODO @Query запрсы должны быть занесены в StringResources
    @Query(
        "SELECT * FROM recipes WHERE tittle = :tittle AND category = :category " +
                "AND label = :label AND id = :recipeId AND imageId = :imageId"
    )
    fun getAllRecipes(
        tittle: String, category: String, label: String, recipeId: Int, imageId: Int
    ): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes where id = :recipeId ")
    fun getRecipeById(recipeId: Int): Recipe

    //TODO мы должны получить список рецептов по модели метода getRecipes после поиска
    @Query("SELECT * FROM recipes WHERE category = :category ORDER BY category ASC")
    fun getRecipesByCategory(category: String): Flow<List<Recipe>>

    @Query("SELECT * FROM recipes WHERE category = :tittle ORDER BY tittle ASC")
    fun getRecipesByTittle(tittle: String): Flow<List<Recipe>>

    //TODO мы должны получить список рецептов по модели метода getRecipes после запроса любимых
    @Query("SELECT * FROM recipes WHERE isFavorite = :isFavorite")
    fun getFavoriteRecipes(isFavorite: Boolean): Flow<List<Recipe>>


    @Query("UPDATE recipes SET isFavorite = :isFavorite WHERE id = :recipeId")
    suspend fun addToFavorite(recipeId: Int, isFavorite: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: Recipe)
}
