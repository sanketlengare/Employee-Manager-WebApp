package com.employeeManager.DBMSProject.mapper;

import com.employeeManager.DBMSProject.dto.EmployeeDto;
import com.employeeManager.DBMSProject.model.Employee;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDto, Employee>{
}
