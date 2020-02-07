package com.rednavis.zuul.controller;

import com.rednavis.core.model.EmployeeEntity;
import com.rednavis.core.repository.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.NameType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulMainController {

  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private MongoTemplate mongoTemplate;

  @GetMapping("/mock")
  public List<String> generateMockEmployee() {
    employeeRepository.deleteAll();

    MockNeat mockNeat = MockNeat.threadLocal();
    List<EmployeeEntity> employeeEntityList = mockNeat.reflect(EmployeeEntity.class)
        .field("organizationId", mockNeat.uuids())
        .field("departmentId", mockNeat.uuids())
        .field("name", mockNeat.names().type(NameType.LAST_NAME))
        .field("age", mockNeat.ints().range(18, 50))
        .field("city", mockNeat.cities().capitals())
        .field("salary", mockNeat.ints().range(100, 1000))
        .list(100)
        .val();

    BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkMode.UNORDERED, EmployeeEntity.class);
    bulkOperations.insert(employeeEntityList);
    bulkOperations.execute();

    return employeeRepository.findAll()
        .stream()
        .map(EmployeeEntity::getId)
        .collect(Collectors.toList());
  }
}
