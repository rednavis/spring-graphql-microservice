package com.rednavis.zuul.config;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Configuration
public class SwaggerConfig {

  @Autowired
  private ZuulProperties properties;

  /**
   * swaggerResourcesProvider.
   *
   * @return
   */
  @Primary
  @Bean
  public SwaggerResourcesProvider swaggerResourcesProvider() {
    return () -> properties.getRoutes()
        .values()
        .stream()
        .map(route -> createResource(route.getServiceId(), route.getId(), "2.0"))
        .collect(Collectors.toList());
  }

  private SwaggerResource createResource(String name, String id, String version) {
    SwaggerResource swaggerResource = new SwaggerResource();
    swaggerResource.setName(name);
    swaggerResource.setLocation("/" + id + "/v2/api-docs");
    swaggerResource.setSwaggerVersion(version);
    return swaggerResource;
  }
}
