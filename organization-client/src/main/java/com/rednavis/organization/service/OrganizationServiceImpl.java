package com.rednavis.organization.service;

import com.rednavis.core.dto.OrganizationDto;
import com.rednavis.core.mapper.OrganizationMapper;
import com.rednavis.core.model.OrganizationEntity;
import com.rednavis.core.repository.OrganizationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

  private static final OrganizationMapper ORGANIZATION_MAPPER = OrganizationMapper.INSTANCE;

  @Autowired
  private OrganizationRepository organizationRepository;

  @Override
  public List<OrganizationDto> findAll() {
    return ORGANIZATION_MAPPER.listEntityTolistDto(organizationRepository.findAll());
  }

  @Override
  public OrganizationDto findById(String id) {
    return ORGANIZATION_MAPPER.entityToDto(organizationRepository.findById(id).orElse(new OrganizationEntity()));
  }
}
