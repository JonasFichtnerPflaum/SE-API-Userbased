package com.example.SEAPIUserbased.database

import com.example.SEAPIUserbased.dto.UserBased
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.stereotype.Service

@Service
class UserBasedService(private val mongoTemplate: MongoTemplate) {

    fun addentrytofavoritlist(userid: String, cocktail: String) {
        val query = Query(Criteria.where("userId").`is`(userid).and("type").`is`("favoritlist"))
        val update = Update().addToSet("list", cocktail)
        mongoTemplate.updateFirst(query, update, UserBased::class.java)
    }

    fun addentrytoshoppinglist(userid: String, ingredient: String) {
        val query = Query(Criteria.where("userId").`is`(userid).and("type").`is`("shoppinglist"))
        val update = Update().addToSet("list", ingredient)
        mongoTemplate.updateFirst(query, update, UserBased::class.java)
    }

    fun removefromfavoritlist(userId: String, cocktail: String) {
        val query = Query(Criteria.where("userId").`is`(userId).and("type").`is`("favoritlist"))
        val update = Update().pull("list", cocktail)
        mongoTemplate.updateFirst(query, update, UserBased::class.java)
    }

    fun removefromshoppinglist(userId: String, ingredient: String) {
        val query = Query(Criteria.where("userId").`is`(userId).and("type").`is`("shoppinglist"))
        val update = Update().pull("list", ingredient)
        mongoTemplate.updateFirst(query, update, UserBased::class.java)
    }
}
