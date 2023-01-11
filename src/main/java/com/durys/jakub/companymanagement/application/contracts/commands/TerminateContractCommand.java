package com.durys.jakub.companymanagement.application.contracts.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import java.util.UUID;

public record TerminateContractCommand(UUID contractId) implements Command {

}
