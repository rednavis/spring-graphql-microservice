package com.rednavis.department.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

  @GetMapping("/info")
  public String info() {
    return "I'm Department-Client";
  }
}
