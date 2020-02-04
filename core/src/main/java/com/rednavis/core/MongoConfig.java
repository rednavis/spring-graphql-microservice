package com.rednavis.core;

import static java.util.Collections.singletonList;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

  @Override
  public String getDatabaseName() {
    return "spring-graphql-microservice";
  }

  @Override
  @Bean
  public MongoClient mongoClient() {
    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
        .applyToClusterSettings(settings -> settings.hosts(singletonList(new ServerAddress("127.0.0.1", 27017))))
        .build();
    return MongoClients.create(mongoClientSettings);
  }
}