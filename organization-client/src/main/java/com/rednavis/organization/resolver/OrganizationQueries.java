package com.rednavis.organization.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rednavis.core.dto.OrganizationDto;
import com.rednavis.organization.service.OrganizationService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class OrganizationQueries implements GraphQLQueryResolver {

  private OrganizationService organizationService;

  public List<OrganizationDto> findAll() {
    log.info("Organizations find");
    return organizationService.findAll();
  }

  public OrganizationDto findById(String id) {
    log.info("OrganizationDto find: id={}", id);
    return organizationService.findById(id);
  }

}
