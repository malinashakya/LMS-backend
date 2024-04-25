package com.example.hrms.model;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    private Long id;
    String fullname;
    private String address;
    private String dateOfBirth;
    private String contact;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="department_code",referencedColumnName = "department_code")

    private Department department;
    public Employee() {
    }

    public Employee(String fullname, String address, String dateOfBirth, String contact, Department department) {

       this.fullname=fullname;
       this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.department = department;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
