package com.lasalle.peliculas.models

// IA generated: Data model for a Movie stack in the selection screen
data class Movie(
    val id: Int,
    val title: String,
    val imageRes: Int, // We'll use a placeholder or resource name
    val tag: String? = null // For "New" or "Bye" labels
)