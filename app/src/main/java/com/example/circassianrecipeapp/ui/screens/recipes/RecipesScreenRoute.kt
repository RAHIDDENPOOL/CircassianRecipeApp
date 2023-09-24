package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun RecipesScreenRoute(
    coordinator: RecipesScreenCoordinator = rememberRecipesScreenCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsState(RecipesScreenState())

    // UI Actions
    val actions = rememberRecipesScreenActions(coordinator)

    // UI Rendering
    RecipesScreenScreen(uiState, actions)
}


@Composable
fun rememberRecipesScreenActions(coordinator: RecipesScreenCoordinator): RecipesScreenActions {
    return remember(coordinator) {
        RecipesScreenActions(
            onClick = coordinator::doStuff
        )
    }
}