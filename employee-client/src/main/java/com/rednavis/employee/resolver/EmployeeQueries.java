package com.rednavis.employee.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rednavis.core.dto.EmployeeDto;
import com.rednavis.employee.service.EmployeeService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class EmployeeQueries implements GraphQLQueryResolver {

  private EmployeeService employeeService;

  public List<EmployeeDto> findAll() {
    log.info("Employees find");
    return employeeService.findAll();
  }

  public EmployeeDto findById(String id) {
    log.info("EmployeeDto find: id={}", id);
    return employeeService.findById(id);
  }

}
