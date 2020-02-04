package com.rednavis.employee;

import com.rednavis.core.CoreModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CoreModule.class)
@EnableDiscoveryClient
public class EmployeeApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeApplication.class, args);
  }
}