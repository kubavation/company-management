package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@AggregateRoot
public abstract class Contract {

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

    public void markWithAnnex(ContractData contractData) {
        annexes.add(new ContractAnnex(contractData, contractId));
    }


    @Getter
    public static class Builder {

        private ContractId contractId;

        private EmployeeId employeeId;

        private ContractNumber contractNumber;

        private ContractData contractData;

        private ContractPeriod contractPeriod;

        private final ContractType contractType;

        private LocalDate from;
        private LocalDate to;

        public static Builder instance(ContractType contractType, ContractId contractId) {
            return new Builder(contractType, contractId);
        }

        private Builder(ContractType contractType, ContractId contractId) {
            this.contractId = contractId;
            this.contractType = contractType;
        }

        public Builder withNumber(String contractNumber) {
            this.contractNumber = new ContractNumber(contractNumber);
            return this;
        }

        public ContractData.Builder data() {
            return ContractData.Builder.instance();
        }

        public Builder in(LocalDate from, LocalDate to) {
            this.from = from;
            this.to = to;
            return this;
        }

        public Builder assignTo(Employee employee) {
            Objects.requireNonNull(employee, "employee to assign must not be null");
            this.employeeId = employee.employeeId();
            return this;
        }

    }

}
