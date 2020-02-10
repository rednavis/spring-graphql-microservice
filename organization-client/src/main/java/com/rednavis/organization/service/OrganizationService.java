package com.rednavis.organization.service;

import com.rednavis.core.dto.OrganizationDto;
import java.util.List;

public interface OrganizationService {

  List<OrganizationDto> findAll();

  OrganizationDto findById(String id);
}
