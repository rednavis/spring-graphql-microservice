package com.rednavis.zuul.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MockDto {

  private List<String> organizationIds;
  private List<String> departmentIds;
  private List<String> employeeIds;

}
