package com.durys.jakub.companymanagement.application.workingtime.requests;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestId;

public record RejectWorkingTimeRequestCommand(WorkingTimeRequestId requestId) implements Command {
}
