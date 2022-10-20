package com.durys.jakub.companymanagement.request.leave_request.service;

import com.durys.jakub.companymanagement.employee.converter.EmployeeMapper;
import com.durys.jakub.companymanagement.employee.model.dto.EmployeeDTO;
import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.CreateLeaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeLeaveRequestFacade {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    private final LeaveRequestService leaveRequestService;

    public List<EmployeeDTO> findStandInEmployees(Long employeeId) {
        return employeeMapper.toDTO(employeeService.findAll());
    }

    public void create(CreateLeaveRequest createLeaveRequest) {

    }
}
