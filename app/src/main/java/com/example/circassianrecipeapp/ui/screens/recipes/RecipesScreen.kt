package com.example.circassianrecipeapp.ui.screens.recipes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.ui.navigation.TopNavigationBar
import com.example.circassianrecipeapp.ui.screens.recipes.components.Carousel
import com.example.circassianrecipeapp.ui.screens.recipes.components.RecipeCardsColumn
import com.example.circassianrecipeapp.ui.utils.VerticalNestedScrollView
import com.example.circassianrecipeapp.ui.utils.rememberNestedScrollViewState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun RecipesScreen(navController: NavController) {
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
                val pagerState = rememberPagerState(pageCount = 10)
                Column {
                    val imageId = arrayOf(
                        R.drawable.dish_one,
                        R.drawable.dish_two,
                        R.drawable.dish_one,
                        R.drawable.dish_two,
                        R.drawable.dish_one,
                        R.drawable.dish_two,
                    )
                    val names = arrayOf(
                        "Peperoni",
                        "Vegan",
                        "FourCheese",
                        "Margaritta",
                        "American",
                        "Mexican",
                    )
                    val ingredients = arrayOf(
                        "Tomato sos, cheese, oregano, peperoni",
                        "Tomato sos, cheese, oregano, spinach, green paprika, rukola",
                        "Tomato sos, oregano, mozzarella, goda, parmesan, cheddar",
                        "Tomato sos, cheese, oregano, bazillion",
                        "Tomato sos, cheese, oregano, green paprika, red beans",
                        "Tomato sos, cheese, oregano, corn, jalapeno, chicken",
                    )
                    val description = arrayOf(
                        "Circassian sos, cheese, oregano, peperoni",
                        "Circassian sos, cheese, oregano, spinach, green paprika, rukola",
                        "Circassian sos, oregano, mozzarella, goda, parmesan, cheddar",
                        "Circassian sos, cheese, oregano, bazillion",
                        "Circassian sos, cheese, oregano, green paprika, red beans",
                        "Circassian sos, cheese, oregano, corn, jalapeno, chicken",
                    )

                    HorizontalPager(
                        modifier = Modifier.weight(1f),
                        state = pagerState,
                    ) {
                        RecipeCardsColumn(
                            imageId = imageId,
                            names = names,
                            subhead = ingredients,
                            description = description,
                            navController = navController,
                        )
                    }
                }
            },
        )
    }
}