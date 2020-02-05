package com.rednavis.organization.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganizationController {

  @GetMapping("/info")
  public String info() {
    return "I'm Organization-Client";
  }
}
