package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Contract {

    private final ContractId contractId;

    private final EmployeeId employeeId;

    private final ContractType contractType;

    private final ContractNumber contractNumber;

    private final ContractData contractData;

    private List<ContractAnnex> annexes;

    public Contract(ContractId contractId, EmployeeId employeeId,
                    ContractType contractType, ContractNumber contractNumber, ContractData contractData) {
        this.contractId = contractId;
        this.employeeId = employeeId;
        this.contractType = contractType;
        this.contractNumber = contractNumber;
        this.contractData = contractData;
        this.annexes = new ArrayList<>();
    }
}
