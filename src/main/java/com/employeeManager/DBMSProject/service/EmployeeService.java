package com.employeeManager.DBMSProject.service;

import com.employeeManager.DBMSProject.dto.EmployeeDto;
import com.employeeManager.DBMSProject.exception.UserNotFoundException;
import com.employeeManager.DBMSProject.mapper.EmployeeMapper;
import com.employeeManager.DBMSProject.model.Employee;
import com.employeeManager.DBMSProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private EmployeeMapper employeeMapper;


    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employee = employeeRepository.save(employee);
        return employeeMapper.toDto(employee);
    }

    public List<EmployeeDto> findAllEmployees() {
        return employeeMapper.toDto(employeeRepository.findAll());
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    public EmployeeDto getEmployeeById(Long id) {
//        Employee employee = employeeRepository.findEmployeeById(id).orElse(null);
//        if (employee == null) {
//            throw new RuntimeException();
//        }
//        return employeeMapper.toDto(employee);
        EmployeeDto employeeDto = null;
        try{
            Employee employee = employeeRepository.findEmployeeById(id).orElse(null);
            employeeDto = employeeMapper.toDto(employee);
        }catch(Exception ex){
            System.out.println("Exception occurred inside EmployeeService's getEmployeeById : "+ex.getMessage());
        }
        return employeeDto;
    }
}
