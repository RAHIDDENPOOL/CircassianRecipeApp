package com.example.circassianrecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.circassianrecipeapp.data.repository.RecipeRepository
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.presentation.navigation.BottomNavigationBar
import com.example.circassianrecipeapp.presentation.navigation.Route
import com.example.circassianrecipeapp.presentation.navigation.TopNavigationBar
import com.example.circassianrecipeapp.presentation.screens.recipes.RecipesScreen
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
        setContent {
            val navController = rememberNavController()
            val viewModel = BaseViewModel(recipeRepository)

            /**
             * NavHost (графы) должны быть определены в папке навигации, отдельно для Bottom
             * и для TopBar, открытие нового экрана -> это UserAction через MVI
             **/

            NavHost(navController = navController, startDestination = Route.RecipesScreen) {
                composable(Route.RecipesScreen) {
                    RecipesScreen(navController = navController, viewModel = viewModel)
                    BottomNavigationBar(navController = navController, viewModel = viewModel)
                    TopNavigationBar()
                }
                composable(Route.DetailScreen) {

                }
                composable(Route.Favorites) {

                }
                composable(Route.Cooking) {

                }
            }
        }
    }
}
