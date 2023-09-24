package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * Screen's coordinator which is responsible for handling actions from the UI layer
 * and one-shot actions based on the new UI state
 */
class RecipesScreenCoordinator(
    val viewModel: RecipesScreenViewModel
) {
    val screenStateFlow = viewModel.stateFlow

    fun doStuff() {
        // TODO Handle UI Action
    }
}

@Composable
fun rememberRecipesScreenCoordinator(
    viewModel: RecipesScreenViewModel = hiltViewModel()
): RecipesScreenCoordinator {
    return remember(viewModel) {
        RecipesScreenCoordinator(
            viewModel = viewModel
        )
    }
}