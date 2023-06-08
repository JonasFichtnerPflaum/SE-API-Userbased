package com.example.SEAPIUserbased.dto

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "favoritcocktail")
data class FavoriteCocktailDto(
    @Id val _id: String?,
    val userId: String,
    val list: MutableList<Cocktail>
)



