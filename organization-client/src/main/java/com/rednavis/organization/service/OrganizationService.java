package com.rednavis.organization.service;

import static com.rednavis.core.mapper.MapperProvider.organizationMapper;

import com.rednavis.core.dto.OrganizationDto;
import com.rednavis.core.mapper.OrganizationMapper;
import com.rednavis.core.model.OrganizationEntity;
import com.rednavis.core.repository.OrganizationRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationService {

  private static final OrganizationMapper ORGANIZATION_MAPPER = organizationMapper();

  private OrganizationRepository organizationRepository;

  public List<OrganizationDto> findAll() {
    return ORGANIZATION_MAPPER.listEntityToListDto(organizationRepository.findAll());
  }

  public OrganizationDto findById(String id) {
    return ORGANIZATION_MAPPER.entityToDto(organizationRepository.findById(id).orElse(new OrganizationEntity()));
  }
}
