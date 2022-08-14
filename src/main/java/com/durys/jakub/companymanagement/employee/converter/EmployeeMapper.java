package com.durys.jakub.companymanagement.employee.converter;

import com.durys.jakub.companymanagement.employee.model.dto.EmployeeDTO;
import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEntity(EmployeeDTO dto);
    List<Employee> toEntity(List<EmployeeDTO> dto);
    EmployeeDTO toDTO(Employee entity);
    List<EmployeeDTO> toDTO(List<Employee> entity);
}
