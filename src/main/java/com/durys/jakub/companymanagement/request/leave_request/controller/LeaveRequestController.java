package com.durys.jakub.companymanagement.request.leave_request.controller;

import com.durys.jakub.companymanagement.request.leave_request.model.converter.LeaveRequestMapper;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestDTO;
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

    private final LeaveRequestMapper leaveRequestMapper;

    @GetMapping("/{employeeId}")
    public List<LeaveRequestDTO> findAllByEmployeeId(@PathVariable Long employeeId) {
        return leaveRequestMapper.toDTO(leaveRequestService.findAllByEmployeeId(employeeId));
    }
}
