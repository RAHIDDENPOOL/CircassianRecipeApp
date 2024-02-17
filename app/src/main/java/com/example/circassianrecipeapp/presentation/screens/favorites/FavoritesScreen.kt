package com.example.circassianrecipeapp.presentation.screens.favorites

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.circassianrecipeapp.presentation.navigation.TopNavigationBar

@Composable
fun FavoritesScreen() {
    TopNavigationBar()
    Text(
        modifier = Modifier.padding(top = 100.dp),
        text = "what was a favorites screen",
    )
}
