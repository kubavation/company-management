package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class Contract {

    private ContractId contractId;

    private EmployeeId employeeId;

    private ContractNumber contractNumber;

    private ContractData contractData;

    private List<ContractAnnex> annexes;

    public Contract(ContractId contractId, EmployeeId employeeId, ContractNumber contractNumber, ContractData contractData) {
        this.contractId = contractId;
        this.employeeId = employeeId;
        this.contractNumber = contractNumber;
        this.contractData = contractData;
        this.annexes = new ArrayList<>();
    }

    public void conclude(EmployeeId employeeId, ContractNumber contractNumber, ContractData contractData) {
        this.contractId = new ContractId(UUID.randomUUID());
        this.employeeId = employeeId;
        this.contractData = contractData;
        this.contractNumber = contractNumber;
        this.annexes = new ArrayList<>();
    }

    public void markWithAnnex(ContractAnnex annex) {
        annexes.add(annex);
    }
}
