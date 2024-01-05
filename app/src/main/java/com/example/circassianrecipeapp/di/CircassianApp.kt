package com.example.circassianrecipeapp.di

import android.app.Application
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.data.RecipeRepository
import com.example.circassianrecipeapp.data.database.entity.Recipe
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class CircassianApp : Application() {
//    @Inject
//    lateinit var database: DatabaseModule

    override fun onCreate() {
        super.onCreate()
//        CoroutineScope(Dispatchers.Default).launch {
//            database.recipeDao()
//        }
        RecipeRepository.initialize(this)
    }

//    private suspend fun initWithPreconditionData() {
//        val recipes = listOf(
//            Recipe(
//                1,
//                R.drawable.dish_one,
//                "Recipe 1",
//                "Category 1",
//                "Ingredients 1",
//                "Instructions 1",
//            ),
//            Recipe(
//                2,
//                R.drawable.dish_two,
//                "Recipe 2",
//                "Category 2",
//                "Ingredients 2",
//                "Instructions 2",
//            ),
//        )
//        recipes.forEach { recipe ->
//            database.recipeDao().upsertRecipe(recipe)
//        }
//    }
}
