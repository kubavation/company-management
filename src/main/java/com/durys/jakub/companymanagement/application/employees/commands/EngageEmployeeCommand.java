package com.durys.jakub.companymanagement.application.employees.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;

import java.time.LocalDate;

public record EngageEmployeeCommand(String firstName, String lastName, String gender,
                                    LocalDate birthdayDate, String departmentId) implements Command {
}
