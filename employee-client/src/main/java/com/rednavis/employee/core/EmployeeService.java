package com.rednavis.employee.core;

import com.rednavis.employee.model.Employee;
import java.util.List;

public interface EmployeeService {

  Employee insert(Employee employee);

  Employee save(Employee employee);

  void deleteById(Long id);

  List<Employee> findAll();

  Employee findById(Long id);
}
