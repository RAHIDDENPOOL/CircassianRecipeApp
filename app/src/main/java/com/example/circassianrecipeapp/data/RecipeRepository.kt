package com.example.circassianrecipeapp.data

import android.content.Context
import androidx.room.Room
import com.example.circassianrecipeapp.data.database.entity.Recipe
import com.example.circassianrecipeapp.di.DatabaseModule
import kotlinx.coroutines.flow.Flow
import java.lang.IllegalStateException

private const val DATABASE_NAME = "recipe-database"

class RecipeRepository private constructor(context: Context) {

    private val database: DatabaseModule = Room
        .databaseBuilder(
            context.applicationContext,
            DatabaseModule::class.java,
            DATABASE_NAME
        )
        .build()

    fun getRecipes(): Flow<List<Recipe>> = database.recipeDao().getRecipes()

    suspend fun getRecipeById(id: Long): Recipe = database.recipeDao().getRecipeById(id)

    companion object {

        private var INSTANCE: RecipeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) INSTANCE = RecipeRepository(context)
        }

        fun get(): RecipeRepository {
            return INSTANCE ?: throw IllegalStateException("RecipeRepository can be initialize")
        }
    }

}