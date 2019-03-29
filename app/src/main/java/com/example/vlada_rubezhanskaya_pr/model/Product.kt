package com.example.vlada_rubezhanskaya_pr.model
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val title: String,
    val author: String,
    val price: String,
    val imageUrl: String
)