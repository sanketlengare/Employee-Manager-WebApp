package com.employeeManager.DBMSProject.mapper;

import com.employeeManager.DBMSProject.dto.EmployeeDto;
import com.employeeManager.DBMSProject.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class employeeMapperImpl implements EmployeeMapper{

    @Override
    public Employee toEntity(EmployeeDto dto) {
        if (dto == null) return null;

        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setJobTitle(dto.getJobTitle());
        employee.setImageUrl(dto.getImageUrl());
        employee.setEmployeeCode(dto.getEmployeeCode());

        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        if (entity == null) return null;

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(entity.getId());
        employeeDto.setName(entity.getName());
        employeeDto.setEmail(entity.getEmail());
        employeeDto.setPhone(entity.getPhone());
        employeeDto.setJobTitle(entity.getJobTitle());
        employeeDto.setImageUrl(entity.getImageUrl());
        employeeDto.setEmployeeCode(entity.getEmployeeCode());

        return employeeDto;
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDto> dtoList) {
        if (dtoList == null) return null;
        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeDto dto : dtoList) {
            Employee employee = toEntity(dto);
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public List<EmployeeDto> toDto(List<Employee> entityList) {
        if (entityList == null) return null;
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee entity : entityList) {
            employeeDtoList.add(toDto(entity));
        }
        return employeeDtoList;
    }
}
