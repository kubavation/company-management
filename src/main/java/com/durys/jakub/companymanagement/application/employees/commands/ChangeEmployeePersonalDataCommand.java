package com.durys.jakub.companymanagement.application.employees.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;

import java.time.LocalDate;
import java.util.UUID;

public record ChangeEmployeePersonalDataCommand(UUID employeeId, String firstName, String lastName,
                                                String gender, LocalDate birthdayDate) implements Command {
}
