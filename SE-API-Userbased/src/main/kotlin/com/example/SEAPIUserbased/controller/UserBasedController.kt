package com.example.SEAPIUserbased.controller

import com.example.SEAPIUserbased.database.UserBasedRepository
import com.example.SEAPIUserbased.database.UserBasedService
import com.example.SEAPIUserbased.dto.UserBased
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UserBasedController (private val userbasedRepository: UserBasedRepository, private val userbasedService: UserBasedService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping("/shoppinglist/{id}")
    fun getshoppinglist(@PathVariable id: String): ResponseEntity<UserBased>{
        return ResponseEntity.ok(userbasedRepository.getshoppinglist(id))
    }

    @GetMapping("/favoritlist/{id}")
    fun getfavoritlist(@PathVariable id: String): ResponseEntity<UserBased>{
        return ResponseEntity.ok(userbasedRepository.getfavoritlist(id))
    }

    @PostMapping("/favoritlist/{id}/add/{cocktail}")
    fun addtofavoritlist(@PathVariable id: String, @PathVariable cocktail: String){
        val savedCocktail = userbasedService.addentrytofavoritlist(id,cocktail)

    }

    @PostMapping("/shoppinglist/{id}/add/{ingredient}")
    fun addtoshoppinglist(@PathVariable id: String, @PathVariable ingredient: String) {
        val savedCocktail = userbasedService.addentrytoshoppinglist(id, ingredient)
    }

    @DeleteMapping("favoritlist/{id}/remove/{cocktail}")
    fun removeformfavoritlist(@PathVariable id: String, @PathVariable cocktail: String): ResponseEntity<String> {
        userbasedService.removefromfavoritlist(id, cocktail)
        return ResponseEntity.ok("String value removed successfully.")
    }

    @DeleteMapping("shoppinglist/{id}/remove/{ingredient}")
    fun removefromshoppinglist(@PathVariable id: String, @PathVariable ingredient: String): ResponseEntity<String> {
        userbasedService.removefromshoppinglist(id, ingredient)
        return ResponseEntity.ok("String value removed successfully.")
    }
}