package com.example.circassianrecipeapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.circassianrecipeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavigationBar(navHostController: NavHostController) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.Recipes),
                style = MaterialTheme.typography.labelMedium,
            )
        },
        navigationIcon = {
            IconButton(onClick = { navHostController.navigate(Route.SEARCHSCREEN) }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                )
            }
        },
        actions = {
            IconButton(onClick = { navHostController.navigate(Route.SETTINGSSCREEN) }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = null,
                )
            }
        }
    )
}