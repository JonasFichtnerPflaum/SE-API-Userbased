package com.example.SEAPIUserbased.database


import com.example.SEAPIUserbased.dto.UserBased
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface UserBasedRepository: MongoRepository<UserBased, String> {
 @Query("{'userId': ?0, 'type': 'shoppinglist'}")
 fun getshoppinglist(id: String): UserBased

 @Query("{'userId': ?0, 'type': 'favoritlist'}")
 fun getfavoritlist(id: String): UserBased

}
