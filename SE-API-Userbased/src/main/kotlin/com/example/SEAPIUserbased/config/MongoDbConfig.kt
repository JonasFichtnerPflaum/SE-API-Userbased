package com.example.SEAPIUserbased.config

import com.example.SEAPIUserbased.StringConverter.StringToCocktailConverter
import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
class MongoDbConfig (private val env: Environment) {

    @Bean(name = ["userBasedTemplate"])
    fun cocktailDbMongoTemplate(): MongoTemplate {
        val settings = MongoClientSettings.builder()
            .applyConnectionString(ConnectionString(env.getProperty("mongodb.connectionString")!!))
            .build()
        return MongoTemplate(MongoClients.create(settings), "test1")
    }
}

