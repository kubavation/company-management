package com.durys.jakub.companymanagement.infrastructure.leaverequests.in_adapters;

import com.durys.jakub.companymanagement.application.leaverequests.LeaveRequestsApplicationService;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.infrastructure.leaverequests.dto.LeaveRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class LeaveRequestController {

    private final LeaveRequestsApplicationService leaveRequestsApplicationService;

    @GetMapping("/employees/{employeeId}/leave-requestes/{leaveRequestId}")
    LeaveRequestDTO findLeaveRequest(@PathVariable Long employeeId, @PathVariable UUID leaveRequestId) {
       // return leaveRequestsApplicationService.loadLeaveRequest(new LeaveRequestId(leaveRequestId));
        throw new UnsupportedOperationException();
    }

}
