package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.commons.domain.DomainServicesRegistry;
import com.durys.jakub.companymanagement.domain.contracts.employment.NoticePeriod;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@AllArgsConstructor
@AggregateRoot
public abstract class Contract {

    protected final ContractId contractId;

    protected final EmployeeId employeeId;

    protected final ContractNumber number;

    protected ContractData data;

    protected ContractPeriod period;

    protected final List<Annex> annexes;



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

    public void terminate(LocalDate dateOfTermination, Period employmentPeriod) {
        LocalDate endDate = calculateEndDate(dateOfTermination, employmentPeriod);
        period = ofPeriod(period.from(), endDate);
    }

    protected abstract ContractPeriod ofPeriod(LocalDate from, LocalDate to);

    protected abstract LocalDate calculateEndDate(LocalDate dateOfTermination, Period employmentPeriod);

    @Getter
    public static class Builder {

        private final ContractType contractType;

        private EmployeeId employeeId;

        private ContractNumber contractNumber;

        private ContractData contractData;

        private LocalDate from;
        private LocalDate to;

        public static Builder instanceOf(ContractType contractType) {
            return new Builder(contractType);
        }

        private Builder(ContractType contractType) {
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
