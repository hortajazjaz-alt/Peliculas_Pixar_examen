package com.lasalle.peliculas.models

// IA generated: Data model for a Character linked to a specific movie
data class Character(
    val id: Int,
    val movieId: Int,
    val name: String,
    val description: String,
    val skills: String,
    val weaknesses: String,
    val imageRes: Int,
    val phoneNumber: String,
    val location: String,
    val shareText: String
)
