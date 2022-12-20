package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

public class ContractAnnex {

    private final AnnexId annexId;
    private final Contract contract;
    private final ContractData contractData;

    public ContractAnnex(AnnexId annexId, ContractData contractData, Contract contract) {
        this.annexId = annexId;
        this.contractData = contractData;
        this.contract = contract;
        contract.recalculateContractData();
    }
}
