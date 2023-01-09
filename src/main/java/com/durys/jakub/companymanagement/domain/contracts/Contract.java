package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.commons.domain.DomainServicesRegistry;
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

    private final ContractNumber number;

    private final ContractData data;

    private final ContractPeriod period;

    private final List<Annex> annexes;

    protected Contract(ContractId contractId, EmployeeId employeeId,
             ContractNumber number, ContractData data,
             ContractPeriod period) {
        this.contractId = contractId;
        this.employeeId = employeeId;
        this.number = number;
        this.data = data;
        this.period = period;
        this.annexes = Collections.emptyList();
    }

    public void markWithAnnex(ContractData contractData) {
        annexes.add(new Annex(contractData, contractId));
    }

    ContractNumber generateNumber(ContractType contractType) {
       return DomainServicesRegistry
                .instanceOf(ContractNumberProvider.class)
                .generate(contractType);
    }


    @Getter
    public static class Builder {

        private final ContractId contractId;

        private final ContractType contractType;

        private EmployeeId employeeId;

        private ContractNumber contractNumber;

        private ContractData contractData;

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
            return ContractData.Builder.instance(this);
        }

        public Builder withData(ContractData contractData) {
            this.contractData = contractData;
            return this;
        }

        public Builder in(LocalDate from, LocalDate to) {
            this.from = from;
            this.to = to;
            return this;
        }

        public Builder from(LocalDate from) {
            this.from = from;
            this.to = null;
            return this;
        }

        public Builder assignTo(Employee employee) {
            Objects.requireNonNull(employee, "employee to assign must not be null");
            this.employeeId = employee.employeeId();
            return this;
        }

    }

}
