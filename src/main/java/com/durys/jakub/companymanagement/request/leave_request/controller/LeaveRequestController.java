package com.durys.jakub.companymanagement.request.leave_request.controller;

import com.durys.jakub.companymanagement.request.leave_request.model.converter.LeaveRequestMapper;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import com.durys.jakub.companymanagement.request.leave_request.service.LeaveRequestService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/leave-requests")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;
    private final LeaveRequestMapper leaveRequestMapper;

    @GetMapping("/employees/{employeeId}")
    public List<LeaveRequestDTO> findAllByEmployeeIdAndRequestType(@PathVariable Long employeeId,
                                                                   @RequestParam(required = false) String type) {

        if (StringUtils.isEmpty(type)) {
            return leaveRequestMapper.toDTO(leaveRequestService.findAllByEmployeeId(employeeId));
        }

        return leaveRequestMapper.toDTO(leaveRequestService.findAllByEmployeeIdAndRequestType(employeeId, LeaveRequestType.ofShortcut(type)));
    }
}
