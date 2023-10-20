package com.example.circassianrecipeapp.ui.screens.recipes.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.circassianrecipeapp.R

@Composable
fun Carousel() {
    LazyRow {
        items(items.take(3)) {
            ItemView(
                modifier = Modifier
                    .animateContentSize(animationSpec = tween(durationMillis = 200))
                    .height(height = TOP_BAR_HEIGHT)
                    .padding(start = 16.dp, end = 8.dp, bottom = 16.dp, top = 8.dp)
                    .fillMaxWidth(),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemView(
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = { /*TODO*/ },
        modifier = modifier
            .height(205.dp)
            .width(154.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(24.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.carousel_first_item),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
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

val TOP_BAR_HEIGHT = 205.dp
