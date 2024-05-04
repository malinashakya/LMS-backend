//package com.example.hrms.model;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//
//@Entity
//@Table(name="employee_leave")
//public class Leave {
//    @Id
//    private Long Leave_id;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
//
//    private String leaveType;
//    private LocalDate leaveStartDate;
//    private LocalDate leaveEndDate;
//    private String leaveReason;
//
//    // Add the status field
//    private String status;
//
//    public Leave() {
//    }
//
//    public Leave(Employee employee, String leaveType, LocalDate leaveStartDate, LocalDate leaveEndDate, String leaveReason, String status) {
//        this.employee = employee;
//        this.leaveType = leaveType;
//        this.leaveStartDate = leaveStartDate;
//        this.leaveEndDate = leaveEndDate;
//        this.leaveReason = leaveReason;
//        this.status = status; // Initialize status
//    }
//
//    public Long getLeave_id() {
//        return Leave_id;
//    }
//
//    public void setLeave_id(Long leave_id) {
//        Leave_id = leave_id;
//    }
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    public String getLeaveType() {
//        return leaveType;
//    }
//
//    public void setLeaveType(String leaveType) {
//        this.leaveType = leaveType;
//    }
//
//    public LocalDate getLeaveStartDate() {
//        return leaveStartDate;
//    }
//
//    public void setLeaveStartDate(LocalDate leaveStartDate) {
//        this.leaveStartDate = leaveStartDate;
//    }
//
//    public LocalDate getLeaveEndDate() {
//        return leaveEndDate;
//    }
//
//    public void setLeaveEndDate(LocalDate leaveEndDate) {
//        this.leaveEndDate = leaveEndDate;
//    }
//
//    public String getLeaveReason() {
//        return leaveReason;
//    }
//
//    public void setLeaveReason(String leaveReason) {
//        this.leaveReason = leaveReason;
//    }
//
//    // Add getter and setter for status
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//}
