package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;

public interface ContractRepository {

    Contract load(ContractId contractId);

    Contract currentOf(EmployeeId employeeId, LocalDate statusAt);

    void save(Contract contract);
}
