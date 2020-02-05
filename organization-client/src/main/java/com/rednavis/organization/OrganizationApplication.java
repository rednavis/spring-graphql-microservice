package com.rednavis.organization;

import com.rednavis.core.CoreModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CoreModule.class)
@EnableDiscoveryClient
@EnableFeignClients
public class OrganizationApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrganizationApplication.class, args);
  }
}
