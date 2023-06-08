package com.example.SEAPIUserbased.config

import com.example.SEAPIUserbased.StringConverter.StringToCocktailConverter
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfig: WebMvcConfigurer {

    override fun addFormatters(registry: FormatterRegistry){
        registry.addConverter(StringToCocktailConverter())
    }
}