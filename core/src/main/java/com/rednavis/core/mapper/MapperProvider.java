package com.rednavis.core.mapper;

import org.mapstruct.factory.Mappers;

public class MapperProvider {

  private static final DepartmentMapper DEPARTMENT_MAPPER = Mappers.getMapper(DepartmentMapper.class);
  private static final EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);
  private static final OrganizationMapper ORGANIZATION_MAPPER = Mappers.getMapper(OrganizationMapper.class);

  public static DepartmentMapper departmentMapper() {
    return DEPARTMENT_MAPPER;
  }

  public static EmployeeMapper employeeMapper() {
    return EMPLOYEE_MAPPER;
  }

  public static OrganizationMapper organizationMapper() {
    return ORGANIZATION_MAPPER;
  }

}
