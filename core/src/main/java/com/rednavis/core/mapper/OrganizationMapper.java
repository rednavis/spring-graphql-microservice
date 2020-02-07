package com.rednavis.core.mapper;

import com.rednavis.core.dto.OrganizationDto;
import com.rednavis.core.model.OrganizationEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrganizationMapper {

  OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

  OrganizationEntity dtoToEntity(OrganizationDto organizationDto);

  OrganizationDto entityToDto(OrganizationEntity organizationEntity);

  List<OrganizationEntity> listDtoTolistEntity(List<OrganizationDto> organizationDtos);

  List<OrganizationDto> listEntityTolistDto(List<OrganizationEntity> organizationEntityList);
}
