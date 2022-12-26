package com.durys.jakub.companymanagement.domain.contracts.vo;

import com.durys.jakub.companymanagement.crud.dictionary.position.model.Position;
import com.durys.jakub.companymanagement.domain.contracts.ContractType;

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
