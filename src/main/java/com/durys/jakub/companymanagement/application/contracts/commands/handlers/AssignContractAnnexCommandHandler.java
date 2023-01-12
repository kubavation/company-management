package com.durys.jakub.companymanagement.application.contracts.commands.handlers;

import com.durys.jakub.companymanagement.application.contracts.commands.AssignContractAnnexCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.contracts.*;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.contracts.vo.Salary;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@CommandHandling
@RequiredArgsConstructor
public class AssignContractAnnexCommandHandler implements CommandHandler<AssignContractAnnexCommand> {

    private final ContractRepository contractRepository;

    @Override
    public void handle(AssignContractAnnexCommand command) {

       Contract contract = contractRepository.load(ContractId.of(command.contractId()));

       Objects.requireNonNull(contract);

       contract.markWithAnnex(command.from(),
               new ContractData(command.position(), command.salary(), command.dailyNumberOfHours(), command.dailyNumberOfMinutes()));

       contractRepository.save(contract);
    }
}
