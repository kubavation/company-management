package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class Contract {

    private final ContractId contractId;

    private final EmployeeId employeeId;

    private final ContractNumber contractNumber;

    private final ContractData contractData;

    private List<ContractAnnex> annexes;

    public Contract(ContractId contractId, EmployeeId employeeId, ContractNumber contractNumber, ContractData contractData) {
        this.contractId = contractId;
        this.employeeId = employeeId;
        this.contractNumber = contractNumber;
        this.contractData = contractData;
        this.annexes = new ArrayList<>();
    }

    public Contract(EmployeeId employeeId, ContractNumber contractNumber, ContractData contractData) {
        this.contractId = new ContractId(UUID.randomUUID());
        this.employeeId = employeeId;
        this.contractNumber = contractNumber;
        this.contractData = contractData;
        this.annexes = new ArrayList<>();
    }

    public void markWithAnnex(ContractData contractData) {
        annexes.add(new ContractAnnex(contractData, contractId));
    }

}
