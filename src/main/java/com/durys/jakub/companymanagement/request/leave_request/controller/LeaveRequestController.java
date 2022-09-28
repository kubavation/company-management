package com.durys.jakub.companymanagement.request.leave_request.controller;

import com.durys.jakub.companymanagement.request.leave_request.model.converter.LeaveRequestMapper;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestFilterDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import com.durys.jakub.companymanagement.request.leave_request.service.LeaveRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/leave-requests")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;
    private final LeaveRequestMapper leaveRequestMapper;

    @GetMapping("/employees/{employeeId}")
    public List<LeaveRequestDTO> findAllByEmployeeIdAndRequestType(@PathVariable Long employeeId,
                                                                   @RequestParam(required = false) String type) {

        log.info("calling findAllByEmployeeIdAndRequestType with employeeId {} and type {}", employeeId, type);

        if (StringUtils.isEmpty(type)) {
            return leaveRequestMapper.toDTO(leaveRequestService.findAllByEmployeeId(employeeId));
        }

        return leaveRequestMapper.toDTO(leaveRequestService.findAllByEmployeeIdAndRequestType(employeeId, LeaveRequestType.ofShortcut(type)));
    }


    @PostMapping("/employees/{employeeId}")
    public List<LeaveRequestDTO> findAllByFilters(@PathVariable Long employeeId, @RequestBody LeaveRequestFilterDTO filters) {

        log.info("calling findAllByFilters with employeeId {} and filters {}", employeeId, filters.toString());

        return leaveRequestMapper.toDTO(leaveRequestService.findAllByFilters(employeeId, filters));
    }
}
