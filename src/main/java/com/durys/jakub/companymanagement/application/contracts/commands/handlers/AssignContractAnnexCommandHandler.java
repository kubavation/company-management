package com.durys.jakub.companymanagement.application.contracts.commands.handlers;

import com.durys.jakub.companymanagement.application.contracts.commands.AssignContractAnnexCommand;
import com.durys.jakub.companymanagement.application.contracts.commands.TerminateContractCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandler;
import com.durys.jakub.companymanagement.cqrs.commands.CommandHandling;
import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractId;
import com.durys.jakub.companymanagement.domain.contracts.ContractRepository;
import com.durys.jakub.companymanagement.domain.contracts.EmploymentService;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.contracts.vo.Salary;
import lombok.RequiredArgsConstructor;

import java.time.Period;
import java.util.Objects;

@CommandHandling
@RequiredArgsConstructor
public class AssignContractAnnexCommandHandler implements CommandHandler<AssignContractAnnexCommand> {

    private final ContractRepository contractRepository;

    @Override
    public void handle(AssignContractAnnexCommand command) {

       Contract contract = contractRepository.load(ContractId.of(command.contractId()));

       Objects.requireNonNull(contract);

       ContractData contractData = new ContractData(null, Salary.withDefaultCurrencyOf(command.salary()), null); //TODO

       contract.markWithAnnex(contractData);

       contractRepository.save(contract);
    }
}
