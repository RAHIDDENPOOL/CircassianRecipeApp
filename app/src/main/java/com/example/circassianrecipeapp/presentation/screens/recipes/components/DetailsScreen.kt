package com.example.circassianrecipeapp.presentation.screens.recipes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.circassianrecipeapp.domain.BaseViewModel
import com.example.circassianrecipeapp.domain.UserAction
import com.example.circassianrecipeapp.domain.UserState

@Composable
fun DetailsScreen(recipeId: Int, viewModel: BaseViewModel) {
    val userState by viewModel.userState.collectAsState()

    LaunchedEffect(recipeId) {
        viewModel.handleIntent(UserAction.OpenRecipe(recipeId))
    }

    when (val content = userState) {
        is UserState.SelectedContent -> {
            val recipe = content.selectedRecipe
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(25.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                Box(
                    Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(text = "Title: ${recipe.title}")
                    Text(text = "That Desc ${recipe.description}")
                }
            }
        }
        // Другие состояния обработайте по аналогии
        else -> { /* Обработка других состояний */
        }
    }
}