package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.input;

import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.AcceptLeaveRequestCommand;
import com.durys.jakub.companymanagement.application.absences.leaverequests.commands.RejectLeaveRequestCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/acceptants/{acceptantId}/leave-requests")
@RequiredArgsConstructor
class AcceptantLeaveRequestsController {

    private final CommandGateway commandGateway;


    @PatchMapping("/{leaveRequestId}/accepted")
    public void accept(@PathVariable UUID acceptantId, @PathVariable UUID leaveRequestId) {
        commandGateway.dispatch(new AcceptLeaveRequestCommand(leaveRequestId, acceptantId));
    }

    @PatchMapping("/{leaveRequestId}/rejected")
    public void reject(@PathVariable UUID acceptantId, @PathVariable UUID leaveRequestId) {
        commandGateway.dispatch(new RejectLeaveRequestCommand(leaveRequestId, acceptantId));
    }

}
