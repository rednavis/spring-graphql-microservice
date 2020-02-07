package com.rednavis.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

  private String id;
  private String name;
  private int age;
  private String city;
  private int salary;
}
