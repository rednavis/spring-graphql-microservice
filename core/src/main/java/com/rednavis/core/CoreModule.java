package com.rednavis.core;

import io.github.kaiso.relmongo.config.EnableRelMongo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ComponentScan
@EnableRelMongo
@EnableMongoRepositories
public class CoreModule {

}
