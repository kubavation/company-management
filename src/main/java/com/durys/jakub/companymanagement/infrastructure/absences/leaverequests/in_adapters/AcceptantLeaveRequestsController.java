package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.in_adapters;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.SubmitLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.dto.LeaveRequestDTO;
import com.durys.jakub.companymanagement.readmodel.leaverequests.EmployeeLeaveRequest;
import com.durys.jakub.companymanagement.readmodel.leaverequests.EmployeeLeaveRequestFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/acceotants/{acceptantId}/leave-requests")
@RequiredArgsConstructor
class AcceptantLeaveRequestsController {

    private final CommandGateway commandGateway;

}
