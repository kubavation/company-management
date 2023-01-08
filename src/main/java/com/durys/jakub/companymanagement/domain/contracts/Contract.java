package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.Getter;

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

        public static Builder withId(ContractId contractId) {
            return new Builder(contractId);
        }

        private Builder(ContractId contractId) {
            this.contractId = contractId;
        }

        public Builder withNumber(String contractNumber) {
            this.contractNumber = new ContractNumber(contractNumber);
            return this;
        }

        public Builder withContractData(ContractData contractData) {
            this.contractData = contractData;
            return this;
        }

        public Builder assignTo(Employee employee) {
            Objects.requireNonNull(employee, "employee to assign must not be null");
            this.employeeId = employee.employeeId();
            return this;
            //return new Contract(contractId, employee.employeeId(), contractNumber, contractData);
        }

    }

}
