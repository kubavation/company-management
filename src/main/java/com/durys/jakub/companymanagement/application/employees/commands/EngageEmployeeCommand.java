package com.durys.jakub.companymanagement.application.employees.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;

public record EngageEmployeeCommand(String firstName, String lastName, String gender) implements Command {
}
