package com.rednavis.department.service;

import com.rednavis.core.dto.DepartmentDto;
import java.util.List;

public interface DepartmentService {

  List<DepartmentDto> findAll();

  DepartmentDto findById(String id);
}
