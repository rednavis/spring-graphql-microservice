package com.rednavis.employee.service;

import com.rednavis.core.model.EmployeeEntity;
import com.rednavis.core.repository.EmployeeRepository;
import com.rednavis.employee.model.EmployeeDto;
import com.rednavis.employee.model.EmployeeMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private static final EmployeeMapper EMPLOYEE_MAPPER = EmployeeMapper.INSTANCE;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public EmployeeDto insert(EmployeeDto employeeDto) {
    EmployeeEntity employeeEntity = EMPLOYEE_MAPPER.dtoToEntity(employeeDto);
    return EMPLOYEE_MAPPER.entityToDto(employeeRepository.insert(employeeEntity));
  }

  @Override
  public EmployeeDto save(EmployeeDto employeeDto) {
    EmployeeEntity employeeEntity = EMPLOYEE_MAPPER.dtoToEntity(employeeDto);
    return EMPLOYEE_MAPPER.entityToDto(employeeRepository.save(employeeEntity));
  }

  @Override
  public boolean deleteById(String id) {
    employeeRepository.deleteById(id);
    return true;
  }

  @Override
  public List<EmployeeDto> findAll() {
    return EMPLOYEE_MAPPER.listEntityTolistDto(employeeRepository.findAll());
  }

  @Override
  public EmployeeDto findById(String id) {
    return EMPLOYEE_MAPPER.entityToDto(employeeRepository.findById(id).orElse(new EmployeeEntity()));
  }

  @Override
  public List<EmployeeDto> findByOrganizationId(String organizationId) {
    return EMPLOYEE_MAPPER.listEntityTolistDto(employeeRepository.findByOrganizationId(organizationId));
  }

  @Override
  public List<EmployeeDto> findByDepartmentId(String departmentId) {
    return EMPLOYEE_MAPPER.listEntityTolistDto(employeeRepository.findByDepartmentId(departmentId));
  }
}
