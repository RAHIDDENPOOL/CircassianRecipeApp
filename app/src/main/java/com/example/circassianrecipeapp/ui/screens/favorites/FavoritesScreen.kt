package com.example.circassianrecipeapp.ui.screens.favorites

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.circassianrecipeapp.ui.navigation.TopAppBar

@Composable
fun FavoritesScreen() {
    TopAppBar()
    Text(
        modifier = Modifier.padding(top = 100.dp),
        text = "what was a favorites screen",
    )
}
