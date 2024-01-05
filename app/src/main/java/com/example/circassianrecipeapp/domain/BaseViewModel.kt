package com.example.circassianrecipeapp.domain

import androidx.lifecycle.ViewModel
import com.example.circassianrecipeapp.data.dao.RecipeDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BaseViewModel @Inject constructor(
    private val dao: RecipeDao
) : ViewModel() {

}