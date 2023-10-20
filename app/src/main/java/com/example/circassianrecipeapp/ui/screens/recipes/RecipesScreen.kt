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
                        "Черкесский гуляш (Либжэ)",
                        "Лягур с пастой",
                        "Гедлибже из курицы",
                        "Лакум",
                        "Ритуальный суп из вяленого мяса (Ашрык)",
                        "Черкесский омлет",
                    )
                    val ingredients = arrayOf(
                        "Говядина, вырезка 700 г",
                        "Лук репчатый 350.г",
                        "Чеснок, сырой 15.г",
                        "Вода 1л",
                        "Соль поваренная пищевая 10.г",
                        "Сметана 15,0% жирности 300.г",
                    )
                    val description = arrayOf(
                        "Это оригинальное блюдо Черкесской кухни готовится из говядины",
                        "Мясо промываем в холодной воде. Мясо зачищаем от мелких костей, пленки и сухожилий и еще раз промываем в холодной проточной воде",
                        "Ставим на большой огонь и быстро доведем до кипения, затем уменьшим нагрев и начнем варить",
                        "Пока варится мясо, на верху кастрюли будет собираться жир и пена, ее обязательно нужно снимать (пена может придать горечь и неприятный запах нашему мясу и бульону)",
                        "Варка считается законченной, если волокна мяса можно отрывать друг от друга руками",
                        "Как только мясо готово, мы расщепим мясо мелкими кусками и переложим в тарелку",
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