package com.durys.jakub.companymanagement.application.workingtime.requests;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestType;

import java.time.LocalDate;
import java.time.LocalTime;

public record SubmitWorkingTimeRequestCommand(EmployeeId employeeId, LocalDate day,  WorkingTimeRequestType type,
                                              LocalTime from, LocalTime to) implements Command {
}
