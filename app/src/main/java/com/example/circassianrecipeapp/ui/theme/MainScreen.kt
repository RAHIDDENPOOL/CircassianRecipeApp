package com.example.circassianrecipeapp.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.circassianrecipeapp.R
//
@Preview
@Composable
fun MainScreen() {
    Carousel()
    //TopAppBar()
}

@Composable
fun TopAppBar() {
    Box(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .background(color = ThemeColorLight) // Background color if needed
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
                fontFamily = FontFamily.Serif // Заменить шрифт на roboto
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

@Composable
fun Carousel() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = ThemeColorLight)
    )
    {
        Text(text = "Рецепты дня")
        Column(
            Modifier
                .width(412.dp)
                .height(221.dp)
                .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier
                    .width(154.dp)
                    .height(205.dp),
                painter = painterResource(id = R.drawable.carousel_first_item),
                contentDescription = null,
                contentScale = ContentScale.None,
            )
        }
    }
}