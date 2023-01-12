package com.durys.jakub.companymanagement.domain.contracts.vo;

import com.durys.jakub.companymanagement.commons.vo.Currency;
import com.durys.jakub.companymanagement.commons.vo.Money;
import com.durys.jakub.companymanagement.domain.contracts.Contract;

import java.math.BigDecimal;

public class ContractData {
    private final Position position;
    private final Salary salary;
    private final WorkingTime workingTime;

    public ContractData(Position position, Salary salary, WorkingTime workingTime) {
        this.position = position;
        this.salary = salary;
        this.workingTime = workingTime;
    }

    public ContractData(String position, BigDecimal salary, int hours, int days) {
        this.position = new Position(position);
        this.salary = Salary.withDefaultCurrencyOf(salary);
        this.workingTime = new WorkingTime(DailyHourNumber.of(hours, days), BillingPeriod.ONE_MONTH); //todo
    }

    public static class Builder {

        private Position position;
        private Salary salary;
        private WorkingTime workingTime;

        private final Contract.Builder contractBuilder;

        public static Builder instance(Contract.Builder contractBuilder) {
            return new Builder(contractBuilder);
        }

        private Builder(Contract.Builder contractBuilder) {
            this.contractBuilder = contractBuilder;
        }

        public Builder earning(BigDecimal amount) {
            this.salary = Salary.withDefaultCurrencyOf(amount);
            return this;
        }

        public Builder earning(BigDecimal amount, Currency currency) {
            this.salary = new Salary(new Money(amount), currency);
            return this;
        }

        public Builder workingAs(String positionName) {
            this.position = new Position(positionName);
            return this;
        }

        public Builder workingTime(int hours, int minutes) {
            this.workingTime = new WorkingTime(DailyHourNumber.of(hours, minutes), BillingPeriod.ONE_MONTH);
            return this;
        }

        public Contract.Builder prepare() {
            contractBuilder.withData(new ContractData(position, salary, workingTime));
            return contractBuilder;
        }

    }
}
