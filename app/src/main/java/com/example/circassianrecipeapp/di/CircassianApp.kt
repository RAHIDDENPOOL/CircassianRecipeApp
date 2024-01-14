package com.example.circassianrecipeapp.di

import android.app.Application
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class CircassianApp : Application() {
    @Inject
    lateinit var recipeRepository: RecipeRepository

    override fun onCreate() {
        super.onCreate()
        //TODO здесь опционально можно запустить viewModelScope.launch{}
        runBlocking {
            recipeRepository.insertInitialRecipes()
        }
    }
}