package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.in_adapters;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.SubmitLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.Applicant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.dto.LeaveRequestDTO;
import com.durys.jakub.companymanagement.readmodel.leaverequests.EmployeeLeaveRequest;
import com.durys.jakub.companymanagement.readmodel.leaverequests.EmployeeLeaveRequestFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees/{employeeId}/leave-requests")
@RequiredArgsConstructor
class EmployeeLeaveRequestsController {

    private final EmployeeLeaveRequestFinder finder;
    private final CommandGateway commandGateway;

    @GetMapping
    List<EmployeeLeaveRequest> findEmployeeLeaveRequests(@PathVariable UUID employeeId) {
        return finder.findAll(EmployeeId.from(employeeId));
    }

    @PostMapping
    void submitLeaveRequest(@PathVariable UUID employeeId, @RequestBody Object todo) {
        //todo
        commandGateway.dispatch(
                new SubmitLeaveRequestCommand(
                        employeeId, LeaveRequestType.AL, LocalDateTime.now(), LocalDateTime.now()));
    }

}
