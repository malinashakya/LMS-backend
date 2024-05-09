package com.example.hrms.controller;

import com.example.hrms.exception.DepartmentNotFoundException;
import com.example.hrms.exception.EmployeeNotFoundException;
import com.example.hrms.model.Employee;
import com.example.hrms.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
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
    @GetMapping("/employees/{employeeId}")
    Employee getEmployeeById(@PathVariable Long employeeId)
    {
        return employeeRepository.findById((employeeId)).orElseThrow(()-> new EmployeeNotFoundException(employeeId));
    }
    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long employeeId)
    {
        return employeeRepository.findById(employeeId).map(employee -> {
            employee.setAddress(newEmployee.getAddress());
            employee.setDateOfBirth(newEmployee.getDateOfBirth());
            employee.setContact(newEmployee.getContact());
            employee.setDepartment(newEmployee.getDepartment());
            return employeeRepository.save(employee);
        }).orElseThrow(()->new EmployeeNotFoundException(employeeId));
    }
    @DeleteMapping("/employees/{employeeId}")
    String deleteEmployee(@PathVariable Long employeeId)
    {

        if(!employeeRepository.existsById(employeeId))
        {
            throw new EmployeeNotFoundException(employeeId);
        }
        employeeRepository.deleteById(employeeId);
        return "Employee with id:"+ employeeId+" has been deleted successfully";
    }
}
