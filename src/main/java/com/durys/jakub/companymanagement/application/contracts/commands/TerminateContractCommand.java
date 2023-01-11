package com.durys.jakub.companymanagement.application.contracts.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;

import java.time.LocalDate;
import java.util.UUID;

public record TerminateContractCommand(UUID contractId, LocalDate terminationDate) implements Command {

}
