package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

public class ContractAnnex {

    private final AnnexId annexId;
    private final Contract contract;

    public ContractAnnex(AnnexId annexId, Contract contract) {
        this.annexId = annexId;
        this.contract = contract;
    }
}
