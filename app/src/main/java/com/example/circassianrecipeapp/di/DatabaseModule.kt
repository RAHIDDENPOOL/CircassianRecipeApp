package com.example.circassianrecipeapp.di

import android.content.Context
import androidx.room.Room
import com.example.circassianrecipeapp.data.dao.RecipeDao
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "local_db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideRecipeDao(database: AppDatabase): RecipeDao = database.recipeDao()

    @Provides
    @Singleton
    fun provideRepository(@ApplicationContext context: Context, dao: RecipeDao): RecipeRepository {
        return RecipeRepository(recipeDao = dao, context = context)
    }
}
