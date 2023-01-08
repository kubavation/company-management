package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.employment.trail.TrailEmployeeContract;

public class ContractFactory {


    Contract instanceOf(ContractType type, Contract.Builder builder) {
        if (ContractType.EMPLOYMENT.equals(type)) {
            return new TrailEmployeeContract(builder);
        }

        throw new UnsupportedOperationException();
    }
}
