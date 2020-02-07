package com.rednavis.core.mapper;

import com.rednavis.core.dto.EmployeeDto;
import com.rednavis.core.model.EmployeeEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

  EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

  EmployeeEntity dtoToEntity(EmployeeDto employeeDto);

  EmployeeDto entityToDto(EmployeeEntity employeeEntity);

  List<EmployeeEntity> listDtoTolistEntity(List<EmployeeDto> employeeDtoList);

  List<EmployeeDto> listEntityTolistDto(List<EmployeeEntity> employeeEntityList);
}
