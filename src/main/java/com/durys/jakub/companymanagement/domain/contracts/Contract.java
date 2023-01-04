package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@AggregateRoot
public class Contract { //todo subclasses

    private final ContractId contractId;

    private final EmployeeId employeeId;

    private final ContractNumber contractNumber;

    private final ContractData contractData;

    private final List<ContractAnnex> annexes;

    public Contract(ContractId contractId, EmployeeId employeeId, ContractNumber contractNumber, ContractData contractData) {
        this.contractId = contractId;
        this.employeeId = employeeId;
        this.contractNumber = contractNumber;
        this.contractData = contractData;
        this.annexes = Collections.emptyList();
    }

    public static Contract prepare(EmployeeId employeeId, ContractNumber contractNumber, ContractData contractData) {
        //todo fix contractId
        return new Contract(new ContractId(UUID.randomUUID()), employeeId, contractNumber, contractData);
    }


    public void markWithAnnex(ContractData contractData) {
        annexes.add(new ContractAnnex(contractData, contractId));
    }

}
