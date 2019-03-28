package com.example.vlada_rubezhanskaya_pr
import android.content.Context
import kotlinx.serialization.Serializable

@Serializable
    data class Categoryprod(
        val title: String,
        val imageUrl: String
    )