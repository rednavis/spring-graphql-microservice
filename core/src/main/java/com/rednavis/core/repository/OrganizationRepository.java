package com.rednavis.core.repository;

import com.rednavis.core.model.OrganizationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationRepository extends MongoRepository<OrganizationEntity, String> {

}
