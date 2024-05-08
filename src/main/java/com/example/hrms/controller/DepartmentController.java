package com.example.hrms.controller;

import com.example.hrms.exception.DepartmentNotFoundException;
import com.example.hrms.model.Department;
import com.example.hrms.model.User;
import com.example.hrms.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("/department")
    Department newDepartment(@RequestBody Department newDepartment){
        return departmentRepository.save(newDepartment);
    }

@GetMapping("/departments")
List<Department> getAllDepartments()
{
    return departmentRepository.findAll();
}

@GetMapping("departments/{department_code}")
    Department getDepartmentByDepartmentCode(@PathVariable String department_code)
{
    return departmentRepository.findById(department_code)
            .orElseThrow(()->new DepartmentNotFoundException(department_code));
}

    @PutMapping("/departments/{department_code}")
    public Department updateDepartment(@RequestBody Department newDepartment, @PathVariable String department_code) {
        return departmentRepository.findById(department_code)
                .map(department -> {
                    department.setDepartment_name(newDepartment.getDepartment_name());
                    return departmentRepository.save(department);
                })
                .orElseThrow(() -> new DepartmentNotFoundException(department_code));
    }

    @DeleteMapping("/departments/{department_code}")
    String deleteDepartment(@PathVariable String department_code)
    {

    if(!departmentRepository.existsById(department_code))
    {
        throw new DepartmentNotFoundException(department_code);
    }
    departmentRepository.deleteById(department_code);
    return "Department with department code:"+ department_code+" has been deleted successfully";
    }
}
