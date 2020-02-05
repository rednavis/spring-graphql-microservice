package com.rednavis.organization.core;

import com.rednavis.organization.model.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

interface OrganizationRepository extends MongoRepository<Organization, Long> {

}
