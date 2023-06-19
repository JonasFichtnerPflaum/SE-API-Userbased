package com.example.SEAPIUserbased.controller

import com.example.SEAPIUserbased.Service.ShoppingListService
import com.example.SEAPIUserbased.dto.ShoppingListDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/shoppinglist")
class ShoppingListController (
    private val shoppingListService: ShoppingListService
    ) {

     @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping("")
    fun getshoppinglist(@RequestParam userId: String): ResponseEntity<List<ShoppingListDto>>{
        return ResponseEntity.ok(shoppingListService.getListById(userId))
    }

    @PostMapping("")
    fun postshoppinglist(@RequestParam userId: String): ShoppingListDto {
        return shoppingListService.createShoppingList(userId)

    }

    @DeleteMapping("/listelement")
    fun deleteshoppinglistelement(@RequestParam userId: String,
                                 @RequestParam element: String): ResponseEntity<Any>{
        return shoppingListService.deleteElement(userId, element)
    }

    @PostMapping("/listelement")
    fun postshoppinglistelement(@RequestParam userId: String,
                               @RequestParam element: String
    ): ResponseEntity<Any>{
        return shoppingListService.addElement(userId, element)
    }
}