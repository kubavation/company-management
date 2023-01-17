package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface ContractRepository {

    Contract load(ContractId contractId);

    Set<Contract> loadBy(EmployeeId employeeId);

    Contract currentOf(EmployeeId employeeId, LocalDate statusAt);

    void save(Contract contract);
}
