package com.rednavis.core.mapper;

import com.rednavis.core.dto.DepartmentDto;
import com.rednavis.core.model.DepartmentEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {

  DepartmentEntity dtoToEntity(DepartmentDto departmentDto);

  DepartmentDto entityToDto(DepartmentEntity departmentEntity);

  List<DepartmentEntity> listDtoToListEntity(List<DepartmentDto> departmentDtoList);

  List<DepartmentDto> listEntityToListDto(List<DepartmentEntity> departmentEntityList);
}
