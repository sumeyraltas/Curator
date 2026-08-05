package com.example.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Artwork(
    val id: String,
    val title: String,
    val artistName: String,
    val creationYear: String,
    val medium: String,
    val dimensions: String = "",
    val location: String = "",
    val description: String,
    val imageUrl: String,
    val thumbnailUrl: String = imageUrl,
    val movement: String = "",
    val isFavorite: Boolean = false,
    val aiAnalysis: String? = null
)

data class ArtMovement(
    val id: String,
    val name: String,
    val era: String,
    val description: String,
    val imageUrl: String
)

data class Museum(
    val id: String,
    val name: String,
    val city: String,
    val country: String,
    val imageUrl: String,
    val artworkCount: Int
)
