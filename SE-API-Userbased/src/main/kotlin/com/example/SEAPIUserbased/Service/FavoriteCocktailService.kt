package com.example.SEAPIUserbased.Service

import com.example.SEAPIUserbased.dto.Cocktail
import com.example.SEAPIUserbased.dto.FavoriteCocktailDto
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.findById
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class FavoriteCocktailService(@Qualifier("userBasedTemplate") private val cocktailDbMongoTemplate: MongoTemplate) {
/*
    fun findAll(): MutableList<FavoriteCocktailDto> {
        return cocktailDbMongoTemplate.findAll(FavoriteCocktailDto::class.java)
    }
*/
    fun getListById(userId: String): List<FavoriteCocktailDto> {
        val query = Query()
            query.addCriteria(Criteria.where("userId").`is`(userId))
        return cocktailDbMongoTemplate.find(query, FavoriteCocktailDto::class.java)
    }

    fun createFavoriteCocktailList(userId: String): FavoriteCocktailDto {
        return cocktailDbMongoTemplate.save(FavoriteCocktailDto(null, userId, mutableListOf()))
    }

    fun deleteCocktail(userId: String, cocktailId: String): FavoriteCocktailDto {
        val query = Query()
        query.addCriteria(Criteria.where("userId").`is`(userId))
        val favoriteCocktailList:List<FavoriteCocktailDto> = cocktailDbMongoTemplate.find(query, FavoriteCocktailDto::class.java)
        val favoriteCocktail: FavoriteCocktailDto
       // if(favoriteCocktailList.isNotEmpty()){
            favoriteCocktail = favoriteCocktailList[0]
       /* }else{
           // return ResponseEntity.ofNullable("no FavoritCocktailList found for userId=$userId")
            return null
        }*/
            val cocktail = favoriteCocktail.list.find { it._id == cocktailId }
            //if (cocktail != null) {
                favoriteCocktail.list.remove(cocktail)
                cocktailDbMongoTemplate.save(favoriteCocktail)
                //return ResponseEntity.noContent().build()
                return favoriteCocktail
            //}
        //return ResponseEntity.notFound().build()
       // return null
    }

    fun addCocktail(userId: String, cocktail: Cocktail): FavoriteCocktailDto {
        val query = Query()
        query.addCriteria(Criteria.where("userId").`is`(userId))
        val favoriteCocktailList: List<FavoriteCocktailDto> =
            cocktailDbMongoTemplate.find(query, FavoriteCocktailDto::class.java)

       // if (favoriteCocktailList.isNotEmpty()) {
            val favoriteCocktail: FavoriteCocktailDto = favoriteCocktailList[0]

            // Check if the cocktail ID already exists in the list
            //if (!favoriteCocktail.list.any { it._id == cocktail._id }) {
                favoriteCocktail.list.add(cocktail)
                val savedFavoriteCocktail = cocktailDbMongoTemplate.save(favoriteCocktail)
                //return ResponseEntity.ok(savedFavoriteCocktail)
                return savedFavoriteCocktail
            //} else {
                //return ResponseEntity.badRequest()
                  //  .body("Cocktail with ID '${cocktail._id}' already exists in the list.")
             //   return null
           // }
        //} else {//todo elseblock vllt entfernen
            // Create a new FavoriteCocktailDto if none exists for the user
          //  val newFavoriteCocktail = FavoriteCocktailDto(null, userId, mutableListOf(cocktail))
         //   val savedFavoriteCocktail = cocktailDbMongoTemplate.save(newFavoriteCocktail)
            //return ResponseEntity.ok(savedFavoriteCocktail)
         //   return savedFavoriteCocktail
        //}
    }
}