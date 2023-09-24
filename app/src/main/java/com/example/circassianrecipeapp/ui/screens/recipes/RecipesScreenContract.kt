package com.example.circassianrecipeapp.ui.screens.recipes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf


/**
 * UI State that represents RecipesScreenScreen
 **/
class RecipesScreenState

/**
 * RecipesScreen Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class RecipesScreenActions(
    val onClick: () -> Unit = {}
)

/**
 * Compose Utility to retrieve actions from nested components
 **/
val LocalRecipesScreenActions = staticCompositionLocalOf<RecipesScreenActions> {
    error("{NAME} Actions Were not provided, make sure ProvideRecipesScreenActions is called")
}

@Composable
fun ProvideRecipesScreenActions(actions: RecipesScreenActions, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalRecipesScreenActions provides actions) {
        content.invoke()
    }
}

