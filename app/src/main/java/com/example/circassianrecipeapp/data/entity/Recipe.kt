package com.example.circassianrecipeapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val recipeId: Int = 0,
    @ColumnInfo(name = "imageFileName")
    val imageFileName: String,
    val title: String,
    val category: String,
    val label: String,
    val description: String,
    val ingredients: String,
    val instructions: String,
    var isFavorite: Boolean
)