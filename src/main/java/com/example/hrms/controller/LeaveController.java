//package com.example.hrms.controller;
//
//import com.example.hrms.exception.LeaveNotFoundException;
//import com.example.hrms.model.Leave;
//import com.example.hrms.repository.LeaveRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin("http://localhost:5173")
//public class LeaveController  {
//    @Autowired
//    private LeaveRepository leaveRepository;
//
//    @PostMapping("/leave")
//    Leave newLeave(@RequestBody Leave newLeave)
//    {
//        return leaveRepository.save(newLeave);
//    }
//
//    @GetMapping("/leaves")
//    List<Leave> getAllLeaves()
//    {
//       return leaveRepository.findAll();
//    }
//    @GetMapping("/leaves/{leave_id}")
//    Leave getLeaveById(@PathVariable Long leave_id){
//        return leaveRepository.findById(leave_id).orElseThrow(()->new LeaveNotFoundException(leave_id));
//    }
//    @PutMapping("/leaves/{leave_id}")
//    public Leave updateLeave(@RequestBody Leave newLeave, @PathVariable Long leave_id) {
//        return leaveRepository.findById(leave_id).map(leave -> {
//            leave.setLeaveEndDate(newLeave.getLeaveEndDate());
//            leave.setLeaveReason(newLeave.getLeaveReason());
//            leave.setLeaveStartDate(newLeave.getLeaveStartDate());
//            leave.setLeaveType(newLeave.getLeaveType());
//            return leaveRepository.save(leave); // Return the updated leave object
//        }).orElseThrow(() -> new LeaveNotFoundException(leave_id));
//    }
//}
