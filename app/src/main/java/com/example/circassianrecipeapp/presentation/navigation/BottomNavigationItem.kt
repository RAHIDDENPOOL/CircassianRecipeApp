package com.example.circassianrecipeapp.presentation.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItemModel(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
)
