package com.rednavis.core.mapper;

import com.rednavis.core.dto.EmployeeDto;
import com.rednavis.core.model.EmployeeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-13T16:11:07+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Azul Systems, Inc.)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setId( employeeDto.getId() );
        employeeEntity.setName( employeeDto.getName() );
        employeeEntity.setAge( employeeDto.getAge() );
        employeeEntity.setCity( employeeDto.getCity() );
        employeeEntity.setSalary( employeeDto.getSalary() );

        return employeeEntity;
    }

    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {
        if ( employeeEntity == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employeeEntity.getId() );
        employeeDto.setName( employeeEntity.getName() );
        employeeDto.setAge( employeeEntity.getAge() );
        employeeDto.setCity( employeeEntity.getCity() );
        employeeDto.setSalary( employeeEntity.getSalary() );

        return employeeDto;
    }

    @Override
    public List<EmployeeEntity> listDtoToListEntity(List<EmployeeDto> employeeDtoList) {
        if ( employeeDtoList == null ) {
            return null;
        }

        List<EmployeeEntity> list = new ArrayList<EmployeeEntity>( employeeDtoList.size() );
        for ( EmployeeDto employeeDto : employeeDtoList ) {
            list.add( dtoToEntity( employeeDto ) );
        }

        return list;
    }

    @Override
    public List<EmployeeDto> listEntityToListDto(List<EmployeeEntity> employeeEntityList) {
        if ( employeeEntityList == null ) {
            return null;
        }

        List<EmployeeDto> list = new ArrayList<EmployeeDto>( employeeEntityList.size() );
        for ( EmployeeEntity employeeEntity : employeeEntityList ) {
            list.add( entityToDto( employeeEntity ) );
        }

        return list;
    }
}
