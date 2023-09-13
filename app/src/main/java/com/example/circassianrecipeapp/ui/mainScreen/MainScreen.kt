package com.example.circassianrecipeapp.ui.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ContentScale.Companion.FillBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.view.theme.MainContentColorMaterialTheme

@Composable
fun MainScreen(
) {

}

@Composable
fun TopAppBar() {
    Box(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .background(color = MainContentColorMaterialTheme)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = null,
                contentScale = ContentScale.None,
                modifier = Modifier
                    .size(24.dp)
            )

            Text(
                text = stringResource(id = R.string.Recipes),
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily.Serif /*TODO - set roboto font*/
            )

            Image(
                painter = painterResource(id = R.drawable.settings_icon),
                contentDescription = null,
                contentScale = ContentScale.None,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemView(
    modifier: Modifier = Modifier
) {
    Card(
        onClick = {/*TODO*/ },
        modifier = modifier
            .height(205.dp)
            .width(154.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = cardElevation(24.dp)
    )
    {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.carousel_first_item),
                contentDescription = null,
                contentScale = FillBounds
            )
        }
    }
}

/*TODO - should be clickable */
@Composable
fun NumberList() {
    val lazyListState = rememberLazyListState()
    LazyRow(state = lazyListState) {
        items(items.take(3)) {
            ItemView(
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp, bottom = 16.dp, top = 8.dp)
                    .fillMaxWidth()
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

@Composable
fun BottomAppBar(navController: NavController) {
    BottomAppBar(
        content = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                IconButton(
                    onClick = {
                        // Навигация на экран "Рецепты"
                        navController.navigate("recipesFragment")
                    }
                ) {
                    Icon(imageVector = Icons.Default.List, contentDescription = "Recipes")
                }

                IconButton(
                    onClick = {
                        // Навигация на экран "Избранное"
                        navController.navigate("favoritesFragment")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorites"
                    )
                }
                IconButton(
                    onClick = {
                        // Навигация на экран "О приложении"
                        navController.navigate("aboutFragment")
                    }
                ) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "About")
                }
            }
        }
    )
}