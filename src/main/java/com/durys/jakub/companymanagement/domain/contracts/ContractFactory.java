package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.employment.fixedterm.FixedTermEmployeeContract;
import com.durys.jakub.companymanagement.domain.contracts.employment.permanent.PermanentEmployeeContract;
import com.durys.jakub.companymanagement.domain.contracts.employment.trail.TrailEmployeeContract;
import com.durys.jakub.companymanagement.domain.contracts.mandate.MandateContract;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContractFactory {


    public static Contract prepare(ContractType type, Contract.Builder builder) {

        return switch (type) {
            case EMPLOYMENT_FIXED_TERM -> new FixedTermEmployeeContract(builder);
            case EMPLOYMENT_PERMANENT -> new PermanentEmployeeContract(builder);
            case EMPLOYMENT_TRAIL -> new TrailEmployeeContract(builder);
            case MANDATE -> new MandateContract(builder);
        };
    }
}
