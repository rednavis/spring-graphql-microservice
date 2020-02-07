package com.rednavis.core.mapper;

import com.rednavis.core.dto.DepartmentDto;
import com.rednavis.core.model.DepartmentEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

  DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

  DepartmentEntity dtoToEntity(DepartmentDto departmentDto);

  DepartmentDto entityToDto(DepartmentEntity departmentEntity);

  List<DepartmentEntity> listDtoTolistEntity(List<DepartmentDto> departmentDtoList);

  List<DepartmentDto> listEntityTolistDto(List<DepartmentEntity> departmentEntityList);
}
