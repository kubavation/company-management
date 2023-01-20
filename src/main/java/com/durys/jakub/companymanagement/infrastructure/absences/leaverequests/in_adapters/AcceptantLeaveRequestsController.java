package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.in_adapters;

import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acceotants/{acceptantId}/leave-requests")
@RequiredArgsConstructor
class AcceptantLeaveRequestsController {

    private final CommandGateway commandGateway;

}
