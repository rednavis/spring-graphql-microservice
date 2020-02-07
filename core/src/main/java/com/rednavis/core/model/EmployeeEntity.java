package com.rednavis.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employee")
public class EmployeeEntity {

  @Id
  private String id;
  private String organizationId;
  private String departmentId;
  private String name;
  private int age;
  private String city;
  private int salary;
}
