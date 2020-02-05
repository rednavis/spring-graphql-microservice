package com.rednavis.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @GetMapping("/info")
  public String info() {
    return "I'm Employee-Client";
  }
}
