package com.rednavis.core.mapper;

import com.rednavis.core.dto.EmployeeDto;
import com.rednavis.core.model.EmployeeEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

  EmployeeEntity dtoToEntity(EmployeeDto employeeDto);

  EmployeeDto entityToDto(EmployeeEntity employeeEntity);

  List<EmployeeEntity> listDtoToListEntity(List<EmployeeDto> employeeDtoList);

  List<EmployeeDto> listEntityToListDto(List<EmployeeEntity> employeeEntityList);
}
