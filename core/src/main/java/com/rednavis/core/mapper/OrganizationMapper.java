package com.rednavis.core.mapper;

import com.rednavis.core.dto.OrganizationDto;
import com.rednavis.core.model.OrganizationEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface OrganizationMapper {

  OrganizationEntity dtoToEntity(OrganizationDto organizationDto);

  OrganizationDto entityToDto(OrganizationEntity organizationEntity);

  List<OrganizationEntity> listDtoToListEntity(List<OrganizationDto> organizationDtos);

  List<OrganizationDto> listEntityToListDto(List<OrganizationEntity> organizationEntityList);
}
