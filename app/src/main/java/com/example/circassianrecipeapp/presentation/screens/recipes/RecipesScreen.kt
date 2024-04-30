package com.example.circassianrecipeapp.presentation.screens.recipes


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.domain.UserAction
import com.example.circassianrecipeapp.domain.UserState
import com.example.circassianrecipeapp.presentation.screens.recipes.components.Carousel
import com.example.circassianrecipeapp.presentation.screens.recipes.components.RecipeCardsColumn
import com.example.circassianrecipeapp.presentation.screens.recipes.utils.VerticalNestedScrollView
import com.example.circassianrecipeapp.presentation.screens.recipes.utils.rememberNestedScrollViewState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipesScreen(navController: NavController, viewModel: BaseViewModel) {
    val userState by remember { viewModel.userState }.collectAsState()
    Scaffold(
        Modifier
            .fillMaxSize()
    ) {
        val nestedScrollViewState = rememberNestedScrollViewState()
        VerticalNestedScrollView(
            state = nestedScrollViewState,
            header = {
                Carousel()
            },
            content = {
                LaunchedEffect(viewModel) {
                    viewModel.handleIntent(UserAction.LoadRecipes)
                }

                when (userState) {
                    is UserState.RecipesList -> {
                        val recipesList = (userState as UserState.RecipesList).recipes
                        RecipeCardsColumn(recipes = recipesList, navController = navController)
                    }

                    is UserState.SelectedContent -> {

                    }

                    is UserState.Loading -> {

                    }

                    is UserState.Error -> {

                    }
                }
            },
        )
    }
}

