package com.durys.jakub.companymanagement.request.leave_request.controller;

import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.service.LeaveRequestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leave-requests")
@AllArgsConstructor
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    @GetMapping("/{employeeId}")
    public List<LeaveRequest> findAllByEmployeeId(@PathVariable Long employeeId) {
        return leaveRequestService.findAllByEmployeeId(employeeId);
    }
}
