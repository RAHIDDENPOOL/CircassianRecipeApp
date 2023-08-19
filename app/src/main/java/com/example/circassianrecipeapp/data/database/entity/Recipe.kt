package com.example.circassianrecipeapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val recipeId: Long,
    val name: String,
    // TODO Category
    val ingredients: String,
    val instructions: String
) {
    override fun toString() = name
}