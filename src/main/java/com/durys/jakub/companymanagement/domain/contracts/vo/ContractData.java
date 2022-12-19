package com.durys.jakub.companymanagement.domain.contracts.vo;

import com.durys.jakub.companymanagement.dictionary.position.model.Position;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class ContractData {
    private final Position position;
    private final Salary salary;

    public ContractData(Position position, Salary salary) {
        this.position = position;
        this.salary = salary;
    }
}
