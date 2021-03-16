package com.management.account.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;


@Configuration
@PropertySource("classpath:application.properties")
public class Config {
    @Autowired
    Environment envi;

    public @Bean 
    MongoDatabaseFactory mongoDatabaseFactory() throws Exception {
        return new SimpleMongoClientDatabaseFactory("mongodb://localhost:27017/management");
    }

    public @Bean 
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDatabaseFactory());
        return mongoTemplate;
    }
}
