package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.in_adapters;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
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

    @GetMapping
    List<EmployeeLeaveRequest> findEmployeeLeaveRequests(@PathVariable UUID employeeId) {
        return finder.findAll(EmployeeId.from(employeeId));
    }

}
