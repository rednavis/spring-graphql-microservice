package com.rednavis.core.repository;

import com.rednavis.core.model.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {

}
