package com.rednavis.department.service;

import com.rednavis.core.dto.DepartmentDto;
import com.rednavis.core.mapper.DepartmentMapper;
import com.rednavis.core.model.DepartmentEntity;
import com.rednavis.core.repository.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private static final DepartmentMapper DEPARTMENT_MAPPER = DepartmentMapper.INSTANCE;

  @Autowired
  private DepartmentRepository departmentRepository;


  @Override
  public List<DepartmentDto> findAll() {
    return DEPARTMENT_MAPPER.listEntityTolistDto(departmentRepository.findAll());
  }

  @Override
  public DepartmentDto findById(String id) {
    return DEPARTMENT_MAPPER.entityToDto(departmentRepository.findById(id).orElse(new DepartmentEntity()));
  }
}
