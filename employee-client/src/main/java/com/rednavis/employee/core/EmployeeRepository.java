package com.rednavis.employee.core;

import com.rednavis.employee.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

interface EmployeeRepository extends MongoRepository<Employee, Long> {

}
