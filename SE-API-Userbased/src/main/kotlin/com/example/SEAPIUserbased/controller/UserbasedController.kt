package com.example.SEAPIUserbased.controller

import com.example.SEAPIUserbased.database.UserbasedRepository
import com.example.SEAPIUserbased.dto.UserBasedData
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/")
class UserbasedController (private val userbasedRepository: UserbasedRepository) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping("/shoppinglist/id/")
    fun getShoppinglistById(@PathVariable id: String): ResponseEntity<List<UserBasedData>>{
        return ResponseEntity.ok(userbasedRepository.findAll())
    }

    @GetMapping("/favoritcocktail/id/{id}")
    fun getfavoritCocktailById(@PathVariable id: String): ResponseEntity<UserBasedData>{
        return ResponseEntity.ok(userbasedRepository.findByIdOrNull(id))
    }
/*
    @PostMapping("/add/favoritcocktail")
    fun addShoppingList(@RequestBody cocktail: Cocktail){
        val savedCocktail = cocktailRepository.save(cocktail)
    }*/
}