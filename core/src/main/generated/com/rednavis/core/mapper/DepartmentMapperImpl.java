package com.rednavis.core.mapper;

import com.rednavis.core.dto.DepartmentDto;
import com.rednavis.core.dto.EmployeeDto;
import com.rednavis.core.model.DepartmentEntity;
import com.rednavis.core.model.EmployeeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-07T14:37:10+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Azul Systems, Inc.)"
)
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentEntity dtoToEntity(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setId( departmentDto.getId() );
        departmentEntity.setName( departmentDto.getName() );
        departmentEntity.setEmployees( employeeDtoListToEmployeeEntityList( departmentDto.getEmployees() ) );

        return departmentEntity;
    }

    @Override
    public DepartmentDto entityToDto(DepartmentEntity departmentEntity) {
        if ( departmentEntity == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( departmentEntity.getId() );
        departmentDto.setName( departmentEntity.getName() );
        departmentDto.setEmployees( employeeEntityListToEmployeeDtoList( departmentEntity.getEmployees() ) );

        return departmentDto;
    }

    @Override
    public List<DepartmentEntity> listDtoTolistEntity(List<DepartmentDto> departmentDtoList) {
        if ( departmentDtoList == null ) {
            return null;
        }

        List<DepartmentEntity> list = new ArrayList<DepartmentEntity>( departmentDtoList.size() );
        for ( DepartmentDto departmentDto : departmentDtoList ) {
            list.add( dtoToEntity( departmentDto ) );
        }

        return list;
    }

    @Override
    public List<DepartmentDto> listEntityTolistDto(List<DepartmentEntity> departmentEntityList) {
        if ( departmentEntityList == null ) {
            return null;
        }

        List<DepartmentDto> list = new ArrayList<DepartmentDto>( departmentEntityList.size() );
        for ( DepartmentEntity departmentEntity : departmentEntityList ) {
            list.add( entityToDto( departmentEntity ) );
        }

        return list;
    }

    protected EmployeeEntity employeeDtoToEmployeeEntity(EmployeeDto employeeDto) {
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

    protected List<EmployeeEntity> employeeDtoListToEmployeeEntityList(List<EmployeeDto> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeeEntity> list1 = new ArrayList<EmployeeEntity>( list.size() );
        for ( EmployeeDto employeeDto : list ) {
            list1.add( employeeDtoToEmployeeEntity( employeeDto ) );
        }

        return list1;
    }

    protected EmployeeDto employeeEntityToEmployeeDto(EmployeeEntity employeeEntity) {
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

    protected List<EmployeeDto> employeeEntityListToEmployeeDtoList(List<EmployeeEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<EmployeeDto> list1 = new ArrayList<EmployeeDto>( list.size() );
        for ( EmployeeEntity employeeEntity : list ) {
            list1.add( employeeEntityToEmployeeDto( employeeEntity ) );
        }

        return list1;
    }
}
