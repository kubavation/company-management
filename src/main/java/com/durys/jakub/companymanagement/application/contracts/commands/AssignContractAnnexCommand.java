package com.durys.jakub.companymanagement.application.contracts.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

//todo
public record AssignContractAnnexCommand(UUID contractId, LocalDate from, BigDecimal salary) implements Command {

}
