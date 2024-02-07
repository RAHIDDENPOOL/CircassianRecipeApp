package com.example.circassianrecipeapp.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.circassianrecipeapp.data.dao.RecipeDao
import com.example.circassianrecipeapp.data.entity.Recipe

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}
