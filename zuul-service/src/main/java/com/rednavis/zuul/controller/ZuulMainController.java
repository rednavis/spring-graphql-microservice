package com.rednavis.zuul.controller;

import com.rednavis.core.model.DepartmentEntity;
import com.rednavis.core.model.EmployeeEntity;
import com.rednavis.core.model.OrganizationEntity;
import com.rednavis.core.repository.DepartmentRepository;
import com.rednavis.core.repository.EmployeeRepository;
import com.rednavis.core.repository.OrganizationRepository;
import com.rednavis.zuul.model.MockDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.types.enums.NameType;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.BulkOperations.BulkMode;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ZuulMainController {

  private final OrganizationRepository organizationRepository;
  private final DepartmentRepository departmentRepository;
  private final EmployeeRepository employeeRepository;
  private final MongoTemplate mongoTemplate;

  /**
   * generateMockEmployee.
   *
   * @return
   */
  @GetMapping("/mock")
  public MockDto generateMockEmployee() {
    organizationRepository.deleteAll();
    departmentRepository.deleteAll();
    employeeRepository.deleteAll();

    MockNeat mockNeat = MockNeat.threadLocal();

    List<EmployeeEntity> employeeEntityList = mockNeat.reflect(EmployeeEntity.class)
        .field("name", mockNeat.names().type(NameType.LAST_NAME))
        .field("age", mockNeat.ints().range(18, 50))
        .field("city", mockNeat.cities().capitals())
        .field("salary", mockNeat.ints().range(100, 1000))
        .list(100)
        .val();
    BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkMode.UNORDERED, EmployeeEntity.class);
    bulkOperations.insert(employeeEntityList);
    bulkOperations.execute();
    employeeEntityList = employeeRepository.findAll();

    List<DepartmentEntity> departmentEntityList = mockNeat.reflect(DepartmentEntity.class)
        .field("name", mockNeat.departments())
        .field("employees", mockNeat.from(employeeEntityList)
            .list(10))
        .list(10)
        .val();
    bulkOperations = mongoTemplate.bulkOps(BulkMode.UNORDERED, DepartmentEntity.class);
    bulkOperations.insert(departmentEntityList);
    bulkOperations.execute();
    departmentEntityList = departmentRepository.findAll();

    List<OrganizationEntity> organizationEntityList = mockNeat.reflect(OrganizationEntity.class)
        .field("name", mockNeat.industries())
        .field("address", mockNeat.countries().names())
        .field("departments", mockNeat.from(departmentEntityList)
            .list(5)
        )
        .list(2)
        .val();

    bulkOperations = mongoTemplate.bulkOps(BulkMode.UNORDERED, OrganizationEntity.class);
    bulkOperations.insert(organizationEntityList);
    bulkOperations.execute();

    return MockDto.builder()
        .organizationIds(organizationRepository.findAll()
            .stream()
            .map(OrganizationEntity::getId)
            .collect(Collectors.toList()))
        .departmentIds(departmentEntityList.stream()
            .map(DepartmentEntity::getId)
            .collect(Collectors.toList()))
        .employeeIds(employeeEntityList.stream()
            .map(EmployeeEntity::getId)
            .collect(Collectors.toList()))
        .build();
  }
}
