package com.example.hrms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id") // Corrected column name
    private Long employeeId; // Corrected field name

    @Column(name = "address")
    private String address;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "contact")
    private String contact;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_code")
    private Department department;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private User user;

    public Employee() {
    }

    public Employee( String address, String dateOfBirth, String contact, Department department, User user) {

        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.contact = contact;
        this.department = department;
        this.user = user;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
        if (user != null) {
            user.setId(employeeId); // Update the user id
        }
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
