package com.durys.jakub.companymanagement.application.contracts.commands.handlers;

import com.durys.jakub.companymanagement.application.contracts.commands.TerminateContractCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractId;
import com.durys.jakub.companymanagement.domain.contracts.ContractRepository;
import com.durys.jakub.companymanagement.domain.contracts.EmploymentService;
import lombok.RequiredArgsConstructor;

import java.time.Period;
import java.util.Objects;

@CommandHandling
@RequiredArgsConstructor
public class TerminateContractCommandHandler implements CommandHandler<TerminateContractCommand> {

    private final ContractRepository contractRepository;
    private final EmploymentService employmentService;

    @Override
    public void handle(TerminateContractCommand command) {

       Contract contract = contractRepository.load(ContractId.of(command.contractId()));

       Objects.requireNonNull(contract);

       Period employmentPeriod = employmentService.employmentPeriod(ContractId.of(command.contractId()));

       //todo
       contract.terminate(command.terminationDate(), employmentPeriod);

       contractRepository.save(contract);
    }
}
