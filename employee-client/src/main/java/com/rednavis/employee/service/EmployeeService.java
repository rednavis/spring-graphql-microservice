package com.rednavis.employee.service;

import static com.rednavis.core.mapper.MapperProvider.employeeMapper;

import com.rednavis.core.dto.EmployeeDto;
import com.rednavis.core.mapper.EmployeeMapper;
import com.rednavis.core.model.EmployeeEntity;
import com.rednavis.core.repository.EmployeeRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

  private static final EmployeeMapper EMPLOYEE_MAPPER = employeeMapper();

  private EmployeeRepository employeeRepository;

  public EmployeeDto insert(EmployeeDto employeeDto) {
    EmployeeEntity employeeEntity = EMPLOYEE_MAPPER.dtoToEntity(employeeDto);
    return EMPLOYEE_MAPPER.entityToDto(employeeRepository.insert(employeeEntity));
  }

  public EmployeeDto save(EmployeeDto employeeDto) {
    EmployeeEntity employeeEntity = EMPLOYEE_MAPPER.dtoToEntity(employeeDto);
    return EMPLOYEE_MAPPER.entityToDto(employeeRepository.save(employeeEntity));
  }

  public boolean deleteById(String id) {
    employeeRepository.deleteById(id);
    return true;
  }

  public List<EmployeeDto> findAll() {
    return EMPLOYEE_MAPPER.listEntityToListDto(employeeRepository.findAll());
  }

  public EmployeeDto findById(String id) {
    return EMPLOYEE_MAPPER.entityToDto(employeeRepository.findById(id).orElse(new EmployeeEntity()));
  }
}
