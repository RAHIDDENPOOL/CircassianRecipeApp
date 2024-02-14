package com.example.circassianrecipeapp.ui.screens.recipes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.example.circassianrecipeapp.domain.Intent
import com.example.circassianrecipeapp.navigation.TopNavigationBar
import com.example.circassianrecipeapp.ui.screens.recipes.components.Carousel
import com.example.circassianrecipeapp.ui.screens.recipes.components.RecipeCardsColumn
import com.example.circassianrecipeapp.ui.screens.recipes.utils.VerticalNestedScrollView
import com.example.circassianrecipeapp.ui.screens.recipes.utils.rememberNestedScrollViewState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun RecipesScreen(navController: NavController) {
    val viewModel: RecipesViewModel = hiltViewModel()
    TopNavigationBar()
    Scaffold(
        Modifier
            .fillMaxSize()
            .padding(top = 55.dp),
    ) {
        val nestedScrollViewState = rememberNestedScrollViewState()
        VerticalNestedScrollView(
            state = nestedScrollViewState,
            header = {
                Carousel()
            },
            content = {
                Column {
                    val recipesState by viewModel.recipes.collectAsState()
                    LaunchedEffect(viewModel) {
                        viewModel.handleIntent(Intent.LoadRecipes)
                    }
                    val pagerState = rememberPagerState(initialPage = 0)
                    HorizontalPager(
                        modifier = Modifier.weight(1f),
                        state = pagerState,
                        count = recipesState.size
                    ) { page ->
                        val recipe = recipesState.getOrNull(page)
                        recipe?.let {
                            RecipeCardsColumn(
                                recipes = recipesState,
                                navController = navController,
                            )
                        }
                    }
                }
            },
        )
    }
}