package com.example.SEAPIUserbased.controller

import com.example.SEAPIUserbased.Service.FavoriteCocktailService
import com.example.SEAPIUserbased.dto.Cocktail
import com.example.SEAPIUserbased.dto.FavoriteCocktailDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/favoritecocktail")
class FavoriteCocktailController(private val favoriteCocktailService: FavoriteCocktailService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping("")
    fun getfavoritcocktail(@RequestParam userId:String): ResponseEntity<List<FavoriteCocktailDto>> {
        return ResponseEntity.ok(favoriteCocktailService.getListById(userId))
    }

    @PostMapping("")
    fun postfavoritcocktail(@RequestParam userId: String): FavoriteCocktailDto{
        return favoriteCocktailService.createFavoriteCocktailList(userId)

    }

    @DeleteMapping("/listelement")
    fun deletefavoritlistelement(@RequestParam userId: String,
                                 @RequestParam cocktailId: String): ResponseEntity<Any>{
        return favoriteCocktailService.deleteCocktail(userId, cocktailId)
    }

    @PostMapping("/listelement")
    fun postfavoritlistelement(@RequestParam userId: String,
                               @RequestBody cocktail: Cocktail): ResponseEntity<Any>{
        return favoriteCocktailService.addCocktail(userId, cocktail)
    }
}