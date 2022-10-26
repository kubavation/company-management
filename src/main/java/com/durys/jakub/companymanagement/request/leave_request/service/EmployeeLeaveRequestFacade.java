package com.durys.jakub.companymanagement.request.leave_request.service;

import com.durys.jakub.companymanagement.employee.converter.EmployeeMapper;
import com.durys.jakub.companymanagement.employee.model.dto.EmployeeDTO;
import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.CreateLeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeLeaveRequestFacade {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    private final LeaveRequestService leaveRequestService;

    public List<EmployeeDTO> findStandInEmployees(Long employeeId) {
        return employeeMapper.toDTO(employeeService.findAll());
    }

    @Transactional
    public void create(CreateLeaveRequest createLeaveRequest) {
       LeaveRequest entity = leaveRequestService.prepareEntity(createLeaveRequest);

       entity.setDays(leaveRequestService
               .numberOfDaysBetween(createLeaveRequest.getDateFrom(), createLeaveRequest.getDateTo()));

       Employee requestAuthor = employeeService
               .findById(createLeaveRequest.getEmployeeId());

       entity.setEmployee(requestAuthor);

       Employee assistance = employeeService
                .findById(createLeaveRequest.getStandInEmployeeId());

       entity.setAssistant(assistance);

        //todo
        Employee accepting = employeeService
                .findById(createLeaveRequest.getStandInEmployeeId());

        entity.setAccepting(accepting);


       leaveRequestService.save(entity);
    }

    public void edit(Long id, CreateLeaveRequest createLeaveRequest) {
        LeaveRequest existingEntity = leaveRequestService.findById(id);
        LeaveRequest entity = leaveRequestService.prepareEntity(createLeaveRequest);

        entity.setId(id);

        entity.setDays(leaveRequestService
                .numberOfDaysBetween(createLeaveRequest.getDateFrom(), createLeaveRequest.getDateTo()));

        Employee requestAuthor = employeeService
                .findById(createLeaveRequest.getEmployeeId());

        entity.setEmployee(requestAuthor);

        Employee assistance = employeeService
                .findById(createLeaveRequest.getStandInEmployeeId());

        entity.setAssistant(assistance);

        //todo
        Employee accepting = employeeService
                .findById(createLeaveRequest.getStandInEmployeeId());

        entity.setAccepting(accepting);

        leaveRequestService.save(entity);
    }

}
