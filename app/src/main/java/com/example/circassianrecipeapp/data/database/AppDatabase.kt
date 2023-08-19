package com.example.circassianrecipeapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.circassianrecipeapp.data.database.entity.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}