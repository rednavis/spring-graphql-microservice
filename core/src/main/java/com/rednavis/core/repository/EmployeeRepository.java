package com.rednavis.core.repository;

import com.rednavis.core.model.EmployeeEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {

  List<EmployeeEntity> findByOrganizationId(String organizationId);

  List<EmployeeEntity> findByDepartmentId(String departmentId);
}
