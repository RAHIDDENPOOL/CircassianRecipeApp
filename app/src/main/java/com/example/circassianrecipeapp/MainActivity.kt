package com.example.circassianrecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.presentation.screens.recipes.RecipesScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var recipeRepository: RecipeRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            recipeRepository.insertRecipesFromJson()
        }
        setContent {
            val navController = rememberNavController()
            val viewModel = BaseViewModel(recipeRepository)
            RecipesScreen(navController = navController, viewModel = viewModel)
        }
    }
}
