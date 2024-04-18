package com.example.circassianrecipeapp.presentation.screens.recipes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Box(
            modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            /*
            Image(
                painter = painterResource(id = photos[itemIndex!!]),
                contentDescription = names[itemIndex],
                modifier.clip(RoundedCornerShape(16.dp)),
            )
        }
        Text(text = names[itemIndex!!], fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Text(text = ingredients[itemIndex], fontSize = 18.sp)
    }*/
        }
    }
}
