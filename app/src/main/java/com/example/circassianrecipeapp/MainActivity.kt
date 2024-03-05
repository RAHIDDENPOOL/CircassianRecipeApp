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
 * Для каждого экрана должна быть фугкция preview, UI должен быть доработан о конону Material3 you
 * Compose функции должны содержать как можно меньше параметров в конструкторе?
 * После глобального рефакторинга, код должен быть в едином стиле, отсмотри все TODO заметки
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

            //Todo(NavHost (графы) должны быть опредлены в папке навигации, отдельно для
            // + Bottom и для TopBar, открытия нового экрана -> это UserAction через MVI)

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
