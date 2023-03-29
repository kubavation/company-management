package com.durys.jakub.companymanagement.infrastructure.contracts.out;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractId;
import com.durys.jakub.companymanagement.domain.contracts.ContractRepository;
import com.durys.jakub.companymanagement.domain.employees.EmployeeId;

import java.time.LocalDate;
import java.util.Set;

public class JdbcContractRepository implements ContractRepository {

    //todo

    @Override
    public Contract load(ContractId contractId) {
        return null;
    }

    @Override
    public Set<Contract> loadBy(EmployeeId employeeId) {
        return null;
    }

    @Override
    public Contract currentOf(EmployeeId employeeId, LocalDate statusAt) {
        return null;
    }

    @Override
    public void save(Contract contract) {

    }
}
