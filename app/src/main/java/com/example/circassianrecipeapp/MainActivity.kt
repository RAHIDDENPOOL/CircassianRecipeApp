package com.example.circassianrecipeapp

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.circassianrecipeapp.di.DatabaseModule
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onResume() {
        super.onResume()
        setContent {
            MviApp()
        }
    }
}
