package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.input;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.CancelLeaveRequestCommand;
import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.SendLeaveRequestForAcceptationCommand;
import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.SubmitLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.dto.LeaveRequestDTO;
import com.durys.jakub.companymanagement.readmodel.leaverequests.EmployeeLeaveRequest;
import com.durys.jakub.companymanagement.readmodel.leaverequests.EmployeeLeaveRequestFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    void submitLeaveRequest(@PathVariable UUID employeeId,
                            @RequestBody LeaveRequestDTO dto) {

        commandGateway.dispatch(
                new SubmitLeaveRequestCommand(
                        employeeId, dto.getRequestType(), dto.getFrom(), dto.getTo()));
    }

    @PatchMapping("/{leaveRequestId}/acceptants/{acceptantId}")
    void sendToAcceptant(@PathVariable UUID leaveRequestId, @PathVariable UUID acceptantId) {

        commandGateway.dispatch(
                new SendLeaveRequestForAcceptationCommand(leaveRequestId, acceptantId));
    }

    @PatchMapping("/{leaveRequestId}/cancelled")
    void cancel(@PathVariable UUID employeeId, @PathVariable UUID leaveRequestId) {

        commandGateway.dispatch(
                new CancelLeaveRequestCommand(leaveRequestId, employeeId));
    }

}
