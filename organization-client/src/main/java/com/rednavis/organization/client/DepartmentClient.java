package com.rednavis.organization.client;

import com.rednavis.organization.model.Department;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface DepartmentClient {

  @GetMapping("/organization/{organizationId}")
  public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId);

  @GetMapping("/organization/{organizationId}/with-employees")
  public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId);

}
