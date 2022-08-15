package com.durys.jakub.companymanagement.request.leave_request.controller;

import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.service.LeaveRequestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave-requests")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    @GetMapping("/{employeeId}")
    public List<LeaveRequest> findAllByEmployeeId(@PathVariable Long employeeId) {
        return leaveRequestService.findAllByEmployeeId(employeeId);
    }
}
