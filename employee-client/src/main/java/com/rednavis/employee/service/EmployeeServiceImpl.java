package com.rednavis.employee.service;

import com.rednavis.core.dto.EmployeeDto;
import com.rednavis.core.mapper.EmployeeMapper;
import com.rednavis.core.model.EmployeeEntity;
import com.rednavis.core.repository.EmployeeRepository;
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
}
