package com.example.circassianrecipeapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.circassianrecipeapp.R
import com.example.circassianrecipeapp.presentation.theme.MainContentColorMaterialTheme

// TODO Переработать Toolbar -> использовать TopAppBar()
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopNavigationBar() {
    val topNavController = rememberNavController()
    MaterialTheme {
        Surface(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .padding(16.dp),
            color = MainContentColorMaterialTheme,
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { topNavController.navigate(Route.SearchScreen) }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                    )
                }

                Text(
                    text = stringResource(id = R.string.Recipes),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .weight(1f),
                )

                IconButton(onClick = { topNavController.navigate(Route.SettingsScreen) }) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Filled.Settings,
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCustomTopAppBar() {
    TopNavigationBar()
}
