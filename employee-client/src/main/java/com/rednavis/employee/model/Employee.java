package com.rednavis.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

  private Long id;
  private Long organizationId;
  private Long departmentId;
  private String name;
  private int age;
  private String position;
  private int salary;
}
