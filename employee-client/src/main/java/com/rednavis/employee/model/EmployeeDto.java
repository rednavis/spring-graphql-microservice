package com.rednavis.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

  private String id;
  private String organizationId;
  private String departmentId;
  private String name;
  private int age;
  private String city;
  private int salary;
}
