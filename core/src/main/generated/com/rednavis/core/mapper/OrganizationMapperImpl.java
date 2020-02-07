package com.rednavis.core.mapper;

import com.rednavis.core.dto.DepartmentDto;
import com.rednavis.core.dto.EmployeeDto;
import com.rednavis.core.dto.OrganizationDto;
import com.rednavis.core.model.DepartmentEntity;
import com.rednavis.core.model.EmployeeEntity;
import com.rednavis.core.model.OrganizationEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-07T14:37:10+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Azul Systems, Inc.)"
)
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public OrganizationEntity dtoToEntity(OrganizationDto organizationDto) {
        if ( organizationDto == null ) {
            return null;
        }

        OrganizationEntity organizationEntity = new OrganizationEntity();

        organizationEntity.setId( organizationDto.getId() );
        organizationEntity.setName( organizationDto.getName() );
        organizationEntity.setAddress( organizationDto.getAddress() );
        organizationEntity.setDepartments( departmentDtoListToDepartmentEntityList( organizationDto.getDepartments() ) );
        organizationEntity.setEmployees( employeeDtoListToEmployeeEntityList( organizationDto.getEmployees() ) );

        return organizationEntity;
    }

    @Override
    public OrganizationDto entityToDto(OrganizationEntity organizationEntity) {
        if ( organizationEntity == null ) {
            return null;
        }

        OrganizationDto organizationDto = new OrganizationDto();

        organizationDto.setId( organizationEntity.getId() );
        organizationDto.setName( organizationEntity.getName() );
        organizationDto.setAddress( organizationEntity.getAddress() );
        organizationDto.setDepartments( departmentEntityListToDepartmentDtoList( organizationEntity.getDepartments() ) );
        organizationDto.setEmployees( employeeEntityListToEmployeeDtoList( organizationEntity.getEmployees() ) );

        return organizationDto;
    }

    @Override
    public List<OrganizationEntity> listDtoTolistEntity(List<OrganizationDto> organizationDtos) {
        if ( organizationDtos == null ) {
            return null;
        }

        List<OrganizationEntity> list = new ArrayList<OrganizationEntity>( organizationDtos.size() );
        for ( OrganizationDto organizationDto : organizationDtos ) {
            list.add( dtoToEntity( organizationDto ) );
        }

        return list;
    }

    @Override
    public List<OrganizationDto> listEntityTolistDto(List<OrganizationEntity> organizationEntityList) {
        if ( organizationEntityList == null ) {
            return null;
        }

        List<OrganizationDto> list = new ArrayList<OrganizationDto>( organizationEntityList.size() );
        for ( OrganizationEntity organizationEntity : organizationEntityList ) {
            list.add( entityToDto( organizationEntity ) );
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

    protected DepartmentEntity departmentDtoToDepartmentEntity(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();

        departmentEntity.setId( departmentDto.getId() );
        departmentEntity.setName( departmentDto.getName() );
        departmentEntity.setEmployees( employeeDtoListToEmployeeEntityList( departmentDto.getEmployees() ) );

        return departmentEntity;
    }

    protected List<DepartmentEntity> departmentDtoListToDepartmentEntityList(List<DepartmentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentEntity> list1 = new ArrayList<DepartmentEntity>( list.size() );
        for ( DepartmentDto departmentDto : list ) {
            list1.add( departmentDtoToDepartmentEntity( departmentDto ) );
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

    protected DepartmentDto departmentEntityToDepartmentDto(DepartmentEntity departmentEntity) {
        if ( departmentEntity == null ) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setId( departmentEntity.getId() );
        departmentDto.setName( departmentEntity.getName() );
        departmentDto.setEmployees( employeeEntityListToEmployeeDtoList( departmentEntity.getEmployees() ) );

        return departmentDto;
    }

    protected List<DepartmentDto> departmentEntityListToDepartmentDtoList(List<DepartmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<DepartmentDto> list1 = new ArrayList<DepartmentDto>( list.size() );
        for ( DepartmentEntity departmentEntity : list ) {
            list1.add( departmentEntityToDepartmentDto( departmentEntity ) );
        }

        return list1;
    }
}
