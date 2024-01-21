package com.example.circassianrecipeapp.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.circassianrecipeapp.data.dao.RecipeDao
import com.example.circassianrecipeapp.data.database.entity.Recipe
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@Singleton
@InstallIn(SingletonComponent::class)
@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class DatabaseModule : RoomDatabase() {
    @Binds
    abstract fun recipeDao(): RecipeDao
}
