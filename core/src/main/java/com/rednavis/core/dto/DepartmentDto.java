package com.rednavis.core.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

  private String id;
  private String name;
  private List<EmployeeDto> employees;
}
