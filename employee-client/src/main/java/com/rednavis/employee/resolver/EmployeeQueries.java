package com.rednavis.employee.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rednavis.core.dto.EmployeeDto;
import com.rednavis.employee.service.EmployeeService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeQueries implements GraphQLQueryResolver {

  @Autowired
  private EmployeeService employeeService;

  public List<EmployeeDto> findAll() {
    log.info("Employees find");
    return employeeService.findAll();
  }

  /**
   * findByOrganization.
   *
   * @param organizationId - organizationId.
   * @return
   */
  public List<EmployeeDto> findByOrganizationId(String organizationId) {
    log.info("Employees find: organizationId={}", organizationId);
    return null;
    //return employeeService.findByOrganizationId(organizationId);
  }

  /**
   * findByDepartment.
   *
   * @param departmentId - departmentId.
   * @return
   */
  public List<EmployeeDto> findByDepartmentId(String departmentId) {
    log.info("Employees find: departmentId={}", departmentId);
    return null;
    //return employeeService.findByDepartmentId(departmentId);
  }

  public EmployeeDto findById(String id) {
    log.info("EmployeeEntity find: id={}", id);
    return employeeService.findById(id);
  }

}