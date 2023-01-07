package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import liquibase.pro.packaged.P;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
@AggregateRoot
public class Contract { //todo subclasses

    private final ContractId contractId;

    private final EmployeeId employeeId;

    private final ContractNumber contractNumber;

    private final ContractData contractData;

    private final List<ContractAnnex> annexes;

    public Contract(ContractId contractId, EmployeeId employeeId, ContractNumber contractNumber, ContractData contractData) {
        this.contractId = contractId;
        this.employeeId = employeeId;
        this.contractNumber = contractNumber;
        this.contractData = contractData;
        this.annexes = Collections.emptyList();
    }

    public static Contract prepare(EmployeeId employeeId, ContractNumber contractNumber, ContractData contractData) {
        //todo fix contractId
        return new Contract(new ContractId(UUID.randomUUID()), employeeId, contractNumber, contractData);
    }


    public void markWithAnnex(ContractData contractData) {
        annexes.add(new ContractAnnex(contractData, contractId));
    }


    public static class ContractBuilder {

        private ContractId contractId;

        private ContractNumber contractNumber;

        private ContractData contractData;

        public static ContractBuilder from(ContractId contractId) {
            return new ContractBuilder(contractId);
        }

        private ContractBuilder(ContractId contractId) {
            this.contractId = contractId;
        }

        public ContractBuilder withNumber(String contractNumber) {
            this.contractNumber = new ContractNumber(contractNumber);
            return this;
        }

        public Contract assignTo(Employee employee) {

            Objects.requireNonNull(employee, "employee to assign must not be null");

            return new Contract(contractId, employee.employeeId(), contractNumber, contractData);
        }

    }

}
