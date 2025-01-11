package com.employeeManager.DBMSProject.resource;

import com.employeeManager.DBMSProject.dto.EmployeeDto;
import com.employeeManager.DBMSProject.model.Employee;
import com.employeeManager.DBMSProject.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> dtoEmployees = employeeService.findAllEmployees();
        return new ResponseEntity<>(dtoEmployees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable("id") Long id) {
        EmployeeDto dtoEmployee = employeeService.getEmployeeById(id);
        if(dtoEmployee==null){
            return new ResponseEntity<>("Employee not found with id "+id, HttpStatus.OK);
        }
        return new ResponseEntity<>(dtoEmployee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto dtoEmployee1 = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(dtoEmployee1, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto dtoEmployee1 = employeeService.updateEmployee(employeeDto);
        return new ResponseEntity<>(dtoEmployee1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
