package com.rednavis.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  /**
   * swaggerApi.
   *
   * @return
   */
  @Bean
  public Docket swaggerApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.rednavis.employee.controller"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(new ApiInfoBuilder().version("1.0")
            .title("Employee API")
            .description("Documentation Employee API v1.0")
            .build());
  }
}
