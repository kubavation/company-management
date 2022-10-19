package com.durys.jakub.companymanagement.request.leave_request.controller;

import com.durys.jakub.companymanagement.employee.converter.EmployeeMapper;
import com.durys.jakub.companymanagement.employee.model.dto.EmployeeDTO;
import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.employee.service.EmployeeService;
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
@Slf4j
public class LeaveRequestController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
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


    @PostMapping
    public List<LeaveRequestDTO> findAllByFilters(@RequestBody LeaveRequestFilterDTO filters) {

        log.info("calling findAllByFilters with filters: {}", filters.toString());

        return leaveRequestMapper.toDTO(leaveRequestService.findAllByFilters(filters));
    }

    @GetMapping("/{employeeId}/standin-employees")
    public List<EmployeeDTO> findStandInEmployees(@PathVariable Long employeeId) {
        return employeeMapper.toDTO(employeeService.findAll()); //todo by dates
    }

    @PostMapping
    public void create(@RequestBody LeaveRequestDTO leaveRequestDTO) {
        log.info("in create {}", leaveRequestDTO);
    }
}
