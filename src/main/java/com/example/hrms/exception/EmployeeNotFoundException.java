package com.example.hrms.exception;

import com.example.hrms.model.Employee;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(Long id){
        super("Could not found the employee with id "+id);
    }
}