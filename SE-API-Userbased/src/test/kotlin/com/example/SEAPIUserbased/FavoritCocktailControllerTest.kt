package com.example.SEAPIUserbased

import com.example.SEAPIUserbased.Service.FavoriteCocktailService
import com.example.SEAPIUserbased.controller.FavoriteCocktailController
import com.example.SEAPIUserbased.dto.Cocktail
import com.example.SEAPIUserbased.dto.FavoriteCocktailDto
import org.junit.Before
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
/*
@RunWith(MockitoJUnitRunner::class)
class FavoritCocktailControllerTest {

    lateinit var mockMvc: MockMvc

    @Mock
    lateinit var favoriteCocktailService: FavoriteCocktailService

    @InjectMocks
    lateinit var favoriteCocktailController: FavoriteCocktailController

    val cocktail1 = Cocktail("647f98c7407886d984b48e70","Whiskey Sour",
        arrayOf("Bourbon","Frischer Zitronensaft","Einfacher Sirup","Orangenscheibe","Kirsche","Eis"),
        "einfach",true,"süß","Bourbon, frischen Zitronensaft und einfachen Sirup in einen Shaker geben. Mit Eis schütteln und in ein Glas mit frischem Eis abseihen. Mit einer Orangenscheibe und einer Kirsche garnieren.")
    val cocktail2 = Cocktail("647f98c7407886d984b48e79","Whiskey Smash",
        arrayOf("Bourbon","Einfacher Sirup","Frischer Zitronensaft","Minzblätter","Zerstoßenes Eis"),
        "mittel",true,"erfrischend","Bourbon, einfachen Sirup und frischen Zitronensaft in einen Shaker geben. Minzblätter hinzufügen und mit einem Stößel leicht zerdrücken. Zerstoßenes Eis hinzufügen und kräftig schütteln. In ein Glas abseihen und mit Minzblättern garnieren.")
    val cocktail3 = Cocktail("647f98c7407886d984b48e90","Ginger Lime Fizz",
        arrayOf("Ingwersirup","Limettensaft","Sprudelwasser","Minzblätter","Eis"),
        "mittel",false,"erfrischend","Ingwersirup, Limettensaft und Minzblätter in ein Glas geben. Gut umrühren und mit Sprudelwasser auffüllen. Eis hinzufügen und vorsichtig umrühren.")
    val favoritCocktail1 = FavoriteCocktailDto("1","1", mutableListOf(cocktail1))
    val favoritCocktail12 = FavoriteCocktailDto("2","2", mutableListOf(cocktail2,cocktail3))
    val favoritCocktail3 = FavoriteCocktailDto("3","3", mutableListOf())
    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        this.mockMvc = MockMvcBuilder. standaloneSetup(favoriteCocktailController).build()
    }

    @Test
    fun getCocktails(){
        //favoriteCocktailController.getfavoritcocktail("")

        mockMvc
    }

}*/

@WebMvcTest(controllers = [FavoriteCocktailController::class])
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension::class)
class FavoriteCocktailControllerTest{


}