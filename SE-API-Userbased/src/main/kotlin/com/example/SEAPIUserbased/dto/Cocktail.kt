package com.example.SEAPIUserbased.dto

import org.springframework.data.annotation.Id

data class Cocktail(
    val _id: String?,
    val name: String,
    val ingredients: Array<String>,
    val difficulty: String,
    val alcoholic: Boolean,
    val taste: String,
    val preparation: String
)
