package com.rednavis.core.repository;

import com.rednavis.core.model.DepartmentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<DepartmentEntity, String> {

}
