package com.durys.jakub.companymanagement.domain.contracts.vo;

import com.durys.jakub.companymanagement.commons.vo.Currency;
import com.durys.jakub.companymanagement.commons.vo.Money;
import com.durys.jakub.companymanagement.domain.contracts.ContractType;

import java.math.BigDecimal;

public class ContractData {
    private final Position position;
    private final Salary salary;
    private final WorkingTime workingTime;
  // private final ContractType contractType;

    public ContractData(Position position, Salary salary, WorkingTime workingTime) {
        this.position = position;
        this.salary = salary;
        this.workingTime = workingTime;
    }

    public static class Builder {

        private Position position;
        private Salary salary;
        private WorkingTime workingTime;


        public Builder earning(BigDecimal amount) {
            this.salary = Salary.withDefaultCurrencyOf(amount); //todo explore domain
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
            this.workingTime = new WorkingTime(DailyHourNumber.of(hours, minutes), BillingPeriod.ONE_MONTH); //todo explore domain
            return this;
        }

        public ContractData prepare() {
            return new ContractData(position, salary, workingTime);
        }
    }
}
