package com.rednavis.employee.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rednavis.employee.core.EmployeeService;
import com.rednavis.employee.model.Employee;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeQueries implements GraphQLQueryResolver {

  @Autowired
  private EmployeeService employeeService;

  public List<Employee> findAll() {
    log.info("Employees find");
    return employeeService.findAll();
  }

  /**
   * findByOrganization.
   *
   * @param organizationId - organizationId.
   * @return
   */
  public List<Employee> findByOrganization(long organizationId) {
    log.info("Employees find: organizationId={}", organizationId);
    return null;
    //return employeeService.findByOrganization(organizationId);
  }

  /**
   * findByDepartment.
   *
   * @param departmentId - departmentId.
   * @return
   */
  public List<Employee> findByDepartment(long departmentId) {
    log.info("Employees find: departmentId={}", departmentId);
    return null;
    //return employeeService.findByDepartment(departmentId);
  }

  public Employee findById(Long id) {
    log.info("Employee find: id={}", id);
    return employeeService.findById(id);
  }

}