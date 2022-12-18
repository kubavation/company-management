package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Contract {

    private final ContractId contractId;

    private final EmployeeId employeeId;

    private final ContractType contractType;

    private final ContractNumber contractNumber;

}
