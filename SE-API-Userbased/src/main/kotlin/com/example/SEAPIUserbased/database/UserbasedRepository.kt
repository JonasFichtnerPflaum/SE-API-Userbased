package com.example.SEAPIUserbased.database

import com.example.SEAPIUserbased.dto.UserBasedData
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface UserbasedRepository : MongoRepository<UserBasedData, String> {
    @Query("{'userId': ?0}")
    fun shoppingListFindByUserId(id: String, type: String): List<UserBasedData>

    @Query("{'userId': ?0}")
    fun favoritListFindByUserId(id: String, type: String): List<UserBasedData>
}
