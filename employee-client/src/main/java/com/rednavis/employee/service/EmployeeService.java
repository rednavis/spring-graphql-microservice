package com.rednavis.employee.service;

import com.rednavis.core.dto.EmployeeDto;
import java.util.List;

public interface EmployeeService {

  EmployeeDto insert(EmployeeDto employeeDto);

  EmployeeDto save(EmployeeDto employeeDto);

  boolean deleteById(String id);

  List<EmployeeDto> findAll();

  EmployeeDto findById(String id);
}
