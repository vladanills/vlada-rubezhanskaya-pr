package com.example.vlada_rubezhanskaya_pr
import kotlinx.serialization.Serializable

@Serializable
data class CategoryProd(
    val title: String,
    val imageUrl: String
)