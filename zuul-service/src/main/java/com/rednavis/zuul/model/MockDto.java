package com.rednavis.zuul.model;

import java.util.List;
import lombok.Builder;

@Builder
public class MockDto {

  private List<String> organizationIds;
  private List<String> departmentIds;
  private List<String> employeeIds;

}
