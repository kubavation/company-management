package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.in_adapters;

import com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.dto.LeaveRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
class LeaveRequestController {

    @GetMapping("/employees/{employeeId}/leave-requestes/{leaveRequestId}")
    LeaveRequestDTO findLeaveRequest(@PathVariable Long employeeId, @PathVariable UUID leaveRequestId) {
       // return leaveRequestsApplicationService.loadLeaveRequest(new LeaveRequestId(leaveRequestId));
        throw new UnsupportedOperationException();
    }

}
