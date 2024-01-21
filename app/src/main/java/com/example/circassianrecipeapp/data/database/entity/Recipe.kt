package com.example.circassianrecipeapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val recipeId: Int = 0,
    @ColumnInfo(name = "imageId")
    val imageId: Int = 0,
    val tittle: String,
    val category: String,
    val label: String,
    val description: String,
    val ingredients: String,
    val instructions: String,
    var isFavorite: Boolean
) : Flow<Nothing?> {
    override suspend fun collect(collector: FlowCollector<Nothing?>) {
        TODO("Not yet implemented")
    }
}
