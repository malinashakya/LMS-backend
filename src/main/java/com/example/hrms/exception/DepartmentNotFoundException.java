package com.example.hrms.exception;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(String department_code){
        super("Could not found the department with department code "+department_code);
    }
}
