package com.example.hrms.controller;

import com.example.hrms.exception.EmployeeNotFoundException;
import com.example.hrms.model.Employee;
import com.example.hrms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee newEmployee)
    {
        return employeeRepository.save(newEmployee);
    }
    @GetMapping("/employees")
    List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }
    @GetMapping("/employees/{id}")
    Employee getEmployeeById(@PathVariable Long id)
    {
        return employeeRepository.findById((id)).orElseThrow(()-> new EmployeeNotFoundException(id));
    }
    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id)
    {
        return employeeRepository.findById(id).map(employee -> {
            employee.setFullname(newEmployee.getFullname());
            employee.setAddress(newEmployee.getAddress());
            employee.setDateOfBirth(newEmployee.getDateOfBirth());
            employee.setContact(newEmployee.getContact());
            employee.setDepartment(newEmployee.getDepartment());
            return employeeRepository.save(employee);
        }).orElseThrow(()->new EmployeeNotFoundException(id));
    }
}
