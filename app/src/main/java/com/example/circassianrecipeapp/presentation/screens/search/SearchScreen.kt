package com.example.circassianrecipeapp.presentation.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.circassianrecipeapp.presentation.theme.CircassianRecipeAppTheme

@Composable
fun SearchScreen() {
    CircassianRecipeAppTheme {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Экран поиска находится на стадии разработки :(",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun PreviewSearchScreen() {
    SearchScreen()
}