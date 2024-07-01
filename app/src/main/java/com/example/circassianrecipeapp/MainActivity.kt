package com.example.circassianrecipeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.presentation.navigation.BottomNavigationBar
import com.example.circassianrecipeapp.presentation.navigation.Navigation
import com.example.circassianrecipeapp.presentation.navigation.TopNavigationBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * MainActivity должен использоваться в контексте Single Activity
 **/
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var recipeRepository: RecipeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            recipeRepository.insertRecipesFromJson()
        }
    }
    override fun onResume() {
        super.onResume()
        setContent { MainContent() }
    }
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun MainContent() {
        val navController = rememberNavController()
        val viewModel = BaseViewModel(recipeRepository)
        Scaffold(
            topBar = { TopNavigationBar(navController) },
            bottomBar = { BottomNavigationBar(navController) }
        ) {
            Navigation(navController, viewModel)
        }
    }
}