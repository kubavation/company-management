package com.durys.jakub.companymanagement.domain.contracts.vo;

import com.durys.jakub.companymanagement.dictionary.position.model.Position;
import com.durys.jakub.companymanagement.domain.contracts.ContractType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class ContractData {
    private final Position position;
    private final Salary salary;
    private final WorkingTime workingTime;

    private final ContractType contractType;

    public ContractData(Position position, Salary salary, WorkingTime workingTime, ContractType contractType) {
        this.position = position;
        this.salary = salary;
        this.workingTime = workingTime;
        this.contractType = contractType;
    }
}
