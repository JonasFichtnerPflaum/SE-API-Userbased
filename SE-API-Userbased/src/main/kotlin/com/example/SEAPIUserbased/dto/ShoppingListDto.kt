package com.example.SEAPIUserbased.dto

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "userBased")
data class ShoppingListDto(
    @Id val _id: String?,
    val userId: String,
    val list: MutableSet<String>
)

