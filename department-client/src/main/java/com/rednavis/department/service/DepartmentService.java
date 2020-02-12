package com.rednavis.department.service;

import static com.rednavis.core.mapper.MapperProvider.departmentMapper;

import com.rednavis.core.dto.DepartmentDto;
import com.rednavis.core.mapper.DepartmentMapper;
import com.rednavis.core.model.DepartmentEntity;
import com.rednavis.core.repository.DepartmentRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {

  private static final DepartmentMapper DEPARTMENT_MAPPER = departmentMapper();

  private DepartmentRepository departmentRepository;

  public List<DepartmentDto> findAll() {
    return DEPARTMENT_MAPPER.listEntityToListDto(departmentRepository.findAll());
  }

  public DepartmentDto findById(String id) {
    return DEPARTMENT_MAPPER.entityToDto(departmentRepository.findById(id).orElse(new DepartmentEntity()));
  }
}
