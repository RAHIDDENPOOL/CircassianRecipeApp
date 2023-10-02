package com.example.circassianrecipeapp.ui.screens.cooking

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.circassianrecipeapp.ui.navigation.TopAppBar

@Composable
fun CookingScreen() {
    TopAppBar()
    Text(
        modifier = Modifier.padding(top = 100.dp),
        text = "what was a cooking screen",
    )
}
