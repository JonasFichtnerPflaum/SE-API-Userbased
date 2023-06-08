package com.example.SEAPIUserbased.Service

import com.example.SEAPIUserbased.dto.FavoriteCocktailDto
import com.example.SEAPIUserbased.dto.ShoppingListDto
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class ShoppingListService(@Qualifier("userBasedTemplate") private val shoppingDbMongoTemplate: MongoTemplate) {

    fun addUser(shoppingList: ShoppingListDto) {
        shoppingDbMongoTemplate.save(shoppingList)

    }

    fun addElement(userId: String, element: String): ResponseEntity<Any> {
        val query = Query()
        query.addCriteria(Criteria.where("userId").`is`(userId))
        val shoppingListList: List<ShoppingListDto> =
            shoppingDbMongoTemplate.find(query, ShoppingListDto::class.java)

        if (shoppingListList.isNotEmpty()) {
            val shoppingList: ShoppingListDto = shoppingListList[0]
            shoppingList.list.add(element)
            val savedShoppingList = shoppingDbMongoTemplate.save(shoppingList)
            return ResponseEntity.ok(savedShoppingList)
        }
        return ResponseEntity.badRequest().body("Shoppinglist for UserID $userId doesn't exisit")
    }

    fun deleteElement(userId: String, element: String): ResponseEntity<Any> {
        val query = Query()
        query.addCriteria(Criteria.where("userId").`is`(userId))
        val shoppingListList:List<ShoppingListDto> = shoppingDbMongoTemplate.find(query, ShoppingListDto::class.java)
        val shoppingList: ShoppingListDto
        if(shoppingListList.isNotEmpty()){
            shoppingList = shoppingListList[0]
        }else{
            return ResponseEntity.ofNullable("no Shoppinglist found for userId=$userId")
        }
        shoppingList.list.remove(element)
        shoppingDbMongoTemplate.save(shoppingList)
        return ResponseEntity.noContent().build()
    }

    fun createShoppingList(userId: String): ShoppingListDto {
        return shoppingDbMongoTemplate.save(ShoppingListDto(null, userId, mutableSetOf()))
    }

    fun getListById(userId: String): List<ShoppingListDto>? {
        val query = Query()
        query.addCriteria(Criteria.where("userId").`is`(userId))
        return shoppingDbMongoTemplate.find(query, ShoppingListDto::class.java)
    }
}
