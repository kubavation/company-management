package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.DomainService;

import java.time.LocalDate;
import java.time.Period;

@DomainService
public class EmploymentService {

    public Period employmentPeriod(ContractId contractId) {
        return Period.between(LocalDate.now(), LocalDate.now()); //todo
    }
}
