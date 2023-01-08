package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.employment.trail.TrailEmployeeContract;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractFactory {


    public static Contract prepare(ContractType type, Contract.Builder builder) {
        if (ContractType.EMPLOYMENT.equals(type)) {
            return new TrailEmployeeContract(builder);
        }

        throw new UnsupportedOperationException();
    }
}
