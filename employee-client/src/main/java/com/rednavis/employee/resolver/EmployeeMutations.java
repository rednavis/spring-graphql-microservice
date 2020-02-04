package com.rednavis.employee.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.rednavis.employee.core.EmployeeService;
import com.rednavis.employee.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeMutations implements GraphQLMutationResolver {

  @Autowired
  private EmployeeService employeeService;

  public Employee insert(Employee employee) {
    log.info("Employee add: employee={}", employee);
    return employeeService.insert(employee);
  }

  public Employee save(Employee employee) {
    log.info("Employee update: employee={}", employee);
    return employeeService.save(employee);
  }

  public void deleteById(Long id) {
    log.info("Employee delete: id={}", id);
    employeeService.deleteById(id);
  }
}