package com.example.circassianrecipeapp.presentation.screens.cooking

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.circassianrecipeapp.presentation.theme.CircassianRecipeAppTheme

@Composable
fun CookingScreen() {
    CircassianRecipeAppTheme {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Экран готовки находится на стадии разработки :(",
                textAlign = TextAlign.Center
            )
        }
    }
}