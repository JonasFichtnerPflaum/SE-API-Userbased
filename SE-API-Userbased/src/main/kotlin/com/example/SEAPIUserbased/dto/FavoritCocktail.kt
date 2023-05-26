package com.example.SEAPIUserbased.dto

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class FavoritCocktail (
    @Id val _id: String?,
    val userId: String?,
    val favoritCocktail: Array<String?>?
)