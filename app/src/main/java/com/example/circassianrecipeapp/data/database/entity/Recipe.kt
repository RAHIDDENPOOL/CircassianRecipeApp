package com.example.circassianrecipeapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val recipeId: Int = 0,
    val imageId: Int,
    val name: String,
    val category: String,
    val ingredients: String,
    val instructions: String,
    var isFavorite: Boolean
) {
    override fun toString() = name
}
