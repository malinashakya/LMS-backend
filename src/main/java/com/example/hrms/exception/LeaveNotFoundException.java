package com.example.hrms.exception;

public class LeaveNotFoundException extends RuntimeException{
    public LeaveNotFoundException(Long leave_id){
        super("Could not found the department with department code "+leave_id);
    }
}
