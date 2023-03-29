package com.durys.jakub.companymanagement.application.workingtime.requests;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.WorkingTimeRequestId;

public record SendWorkingTimeRequestForAcceptationCommand(WorkingTimeRequestId requestId, EmployeeId acceptantId) implements Command {
}
