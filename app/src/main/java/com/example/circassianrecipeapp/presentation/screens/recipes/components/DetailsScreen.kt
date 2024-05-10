package com.example.circassianrecipeapp.presentation.screens.recipes.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.domain.UserAction
import com.example.circassianrecipeapp.domain.UserState
import com.example.circassianrecipeapp.presentation.navigation.Route
import com.example.circassianrecipeapp.presentation.theme.CircassianRecipeAppTheme
import com.example.circassianrecipeapp.presentation.theme.PickedColorMaterialTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(recipeId: Int, viewModel: BaseViewModel, navController: NavController) {
    CircassianRecipeAppTheme {
        val userState by viewModel.userState.collectAsState()
        LaunchedEffect(recipeId) {
            viewModel.handleIntent(UserAction.OpenRecipe(recipeId))
        }
        when (val content = userState) {
            is UserState.SelectedContent -> {
                val recipe = content.selectedRecipe
                Scaffold(
                    topBar = {
                        androidx.compose.material.TopAppBar(
                            title = { Text(text = recipe.title) },
                            actions = {
                                IconButton(onClick = { navController.navigate(Route.RECIPESSCREEN) }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = null,
                                    )
                                }
                            }
                        )
                    }
                )
                {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.dish_one), //Todo непонятно как передать картинку
                                contentDescription = "Recipe Image",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(bottom = 16.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = recipe.title,
                                style = TextStyle.Default,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Text(
                                text = recipe.category,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.Gray,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                NutritionLabel(
                                    icon = Icons.Default.FavoriteBorder,
                                    value = "kcal"
                                )
                                NutritionLabel(icon = Icons.Default.AccountBox, value = "g")
                                NutritionLabel(icon = Icons.Default.Build, value = "g")
                                NutritionLabel(icon = Icons.Default.ShoppingCart, value = "g")
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = recipe.ingredients,
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Text(
                                text = recipe.instructions,
                                style = MaterialTheme.typography.bodySmall,
                                textAlign = TextAlign.Justify
                            )
                        }
                    }

                }
            }

            else -> {
                /* Обработка других состояний */
            }
        }
    }
}

@Composable
fun NutritionLabel(icon: ImageVector, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surface
        )
        Text(
            text = value,
            style = MaterialTheme.typography.labelLarge,
            color = Color.Gray
        )
    }
}