package com.rednavis.department.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rednavis.core.dto.DepartmentDto;
import com.rednavis.department.service.DepartmentService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class DepartmentQueries implements GraphQLQueryResolver {

  private DepartmentService departmentService;

  public List<DepartmentDto> findAll() {
    log.info("Departments find");
    return departmentService.findAll();
  }

  public DepartmentDto findById(String id) {
    log.info("DepartmentDto find: id={}", id);
    return departmentService.findById(id);
  }

}
