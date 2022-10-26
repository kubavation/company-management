package com.durys.jakub.companymanagement.request.leave_request.controller;

import com.durys.jakub.companymanagement.employee.converter.EmployeeMapper;
import com.durys.jakub.companymanagement.employee.model.dto.EmployeeDTO;
import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import com.durys.jakub.companymanagement.request.leave_request.model.converter.LeaveRequestMapper;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.CreateLeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestFilterDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import com.durys.jakub.companymanagement.request.leave_request.service.EmployeeLeaveRequestFacade;
import com.durys.jakub.companymanagement.request.leave_request.service.LeaveRequestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave-requests")
@AllArgsConstructor
@Slf4j
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;
    private final LeaveRequestMapper leaveRequestMapper;
    private final EmployeeLeaveRequestFacade employeeLeaveRequestFacade;

    @GetMapping("/employees/{employeeId}")
    public List<LeaveRequestDTO> findAllByEmployeeIdAndRequestType(@PathVariable Long employeeId,
                                                                   @RequestParam(required = false) String type) {


        log.info("calling findAllByEmployeeIdAndRequestType with employeeId {} and type {}", employeeId, type);

        if (StringUtils.isEmpty(type)) {
            return leaveRequestMapper.toDTO(leaveRequestService.findAllByEmployeeId(employeeId));
        }

        return leaveRequestMapper.toDTO(leaveRequestService.findAllByEmployeeIdAndRequestType(employeeId, LeaveRequestType.ofShortcut(type)));
    }


    @PostMapping("/filters")
    public List<LeaveRequestDTO> findAllByFilters(@RequestBody LeaveRequestFilterDTO filters) {

        log.info("calling findAllByFilters with filters: {}", filters.toString());

        return leaveRequestMapper.toDTO(leaveRequestService.findAllByFilters(filters));
    }

    @GetMapping("/{employeeId}/standin-employees")
    public List<EmployeeDTO> findStandInEmployees(@PathVariable Long employeeId) {
        return employeeLeaveRequestFacade.findStandInEmployees(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateLeaveRequest createLeaveRequest) {
        log.info("in create {}", createLeaveRequest);
        employeeLeaveRequestFacade.create(createLeaveRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void edit(@PathVariable Long id, @RequestBody CreateLeaveRequest createLeaveRequest) {
        log.info("in edit {}", createLeaveRequest);
        employeeLeaveRequestFacade.edit(id, createLeaveRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        log.info("in delete id = {}", id);
        leaveRequestService.delete(id);
    }
}
