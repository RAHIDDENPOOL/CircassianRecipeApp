package com.example.circassianrecipeapp.presentation.screens.recipes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.data.entity.Recipe
import com.example.circassianrecipeapp.presentation.navigation.Route
import com.example.circassianrecipeapp.presentation.theme.DescriptionTextColorMaterialTheme
import com.example.circassianrecipeapp.presentation.theme.IconColor
import com.example.circassianrecipeapp.presentation.theme.TitleTextColorMaterialTheme
import kotlinx.coroutines.flow.Flow

@Composable
fun RecipeCardsColumn(
    recipes: Flow<List<Recipe>>,
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val recipesList by recipes.collectAsState(emptyList())
    MaterialTheme {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(recipesList) { recipe ->
                ColumnItem(
                    modifier = modifier
                        .fillMaxWidth()
                        .clickable { navController.navigate("${Route.DetailScreen}/$recipe.id") },
                    recipe = recipe
                )
            }
        }
    }
}

@Composable
fun ColumnItem(
    modifier: Modifier,
    recipe: Recipe
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.dish_one),
                contentDescription = recipe.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = recipe.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = TitleTextColorMaterialTheme,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = recipe.label,
                fontSize = 16.sp,
                color = DescriptionTextColorMaterialTheme,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = recipe.description,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = DescriptionTextColorMaterialTheme,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(40.dp)
                        .padding(end = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                ) {
                    Text(
                        text = "Сладости",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(40.dp)
                        .padding(start = 8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
                ) {
                    Text(
                        text = "На второе",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorites),
                    contentDescription = null,
                    tint = IconColor,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterVertically),
                )
            }
        }
    }
}