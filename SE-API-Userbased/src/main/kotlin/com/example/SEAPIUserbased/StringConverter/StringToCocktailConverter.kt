package com.example.SEAPIUserbased.StringConverter
import com.example.SEAPIUserbased.dto.Cocktail
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.convert.converter.Converter
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.stereotype.Component

@Component
class StringToCocktailConverter : Converter<String, Cocktail> {

        private val objectMapper: ObjectMapper = Jackson2ObjectMapperBuilder.json().build()
        override fun convert(source: String): Cocktail {
            print("test$source")// Use Jackson ObjectMapper to convert the JSON string to a Cocktail object
            return objectMapper.readValue(source, Cocktail::class.java)
        }
}