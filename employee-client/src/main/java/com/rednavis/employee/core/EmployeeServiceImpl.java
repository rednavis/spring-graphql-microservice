package com.rednavis.employee.core;

import com.rednavis.employee.model.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Employee insert(Employee employee) {
    return employeeRepository.insert(employee);
  }

  @Override
  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public void deleteById(Long id) {
    employeeRepository.deleteById(id);
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(Long id) {
    return employeeRepository.findById(id).orElse(new Employee());
  }
}
