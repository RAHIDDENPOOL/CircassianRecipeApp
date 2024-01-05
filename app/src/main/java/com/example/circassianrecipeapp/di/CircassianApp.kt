package com.example.circassianrecipeapp.di

import android.app.Application
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.data.database.entity.Recipe
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class CircassianApp : Application() {
    @Inject
    lateinit var database: DatabaseModule

    override fun onCreate() {
        super.onCreate()
        CoroutineScope(Dispatchers.Default).launch {
            database.recipeDao()
        }
    }
}
