package com.rednavis.employee.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.rednavis.core.dto.EmployeeDto;
import com.rednavis.employee.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeMutations implements GraphQLMutationResolver {

  @Autowired
  private EmployeeService employeeService;

  public EmployeeDto insert(EmployeeDto employeeDto) {
    log.info("Employee add: employeeDto={}", employeeDto);
    return employeeService.insert(employeeDto);
  }

  public EmployeeDto save(EmployeeDto employeeDto) {
    log.info("Employee update: EmployeeDto={}", employeeDto);
    return employeeService.save(employeeDto);
  }

  public boolean deleteById(String id) {
    log.info("Employee delete: id={}", id);
    return employeeService.deleteById(id);
  }
}