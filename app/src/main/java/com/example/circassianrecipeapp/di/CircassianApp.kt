package com.example.circassianrecipeapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class CircassianApp : Application() {
    @Inject
    lateinit var database: DatabaseModule

    override fun onCreate() {
        super.onCreate()
        //TODO здесь опционально можно запустить viewModelScope.launch{}
        runBlocking {
            database.recipeDao()
        }
    }
}
