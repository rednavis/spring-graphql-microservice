package com.rednavis.employee.service;

import com.rednavis.employee.model.EmployeeDto;
import java.util.List;

public interface EmployeeService {

  EmployeeDto insert(EmployeeDto employeeDto);

  EmployeeDto save(EmployeeDto employeeDto);

  boolean deleteById(String id);

  List<EmployeeDto> findAll();

  EmployeeDto findById(String id);

  List<EmployeeDto> findByOrganizationId(String organizationId);

  List<EmployeeDto> findByDepartmentId(String departmentId);
}
