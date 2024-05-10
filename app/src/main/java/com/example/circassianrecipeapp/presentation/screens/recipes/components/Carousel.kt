package com.example.circassianrecipeapp.presentation.screens.recipes.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.presentation.theme.CircassianRecipeAppTheme
import com.example.circassianrecipeapp.presentation.theme.MainContentColorMaterialTheme
import com.example.circassianrecipeapp.presentation.theme.UnPickedColorMaterialTheme

@Composable
fun Carousel() {
    CircassianRecipeAppTheme {
        LazyRow {
            items(items.take(3)) {
                ItemView(
                    modifier = Modifier
                        .animateContentSize(animationSpec = tween(durationMillis = 200))
                        .padding(start = 16.dp, end = 8.dp, bottom = 16.dp, top = 63.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun ItemView(
    modifier: Modifier = Modifier,
) {
    CircassianRecipeAppTheme {
        Card(
            onClick = { /*TODO*/ },
            modifier = modifier
                .height(205.dp)
                .width(154.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.circassian_flag),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                )
            }
        }
    }
}

/*TODO extract this to the data layer -> ViewModel or Repository*/
data class Items(
    val num: Int,
)

val items = listOf(
    Items(num = 1),
    Items(num = 2),
    Items(num = 3),
)
