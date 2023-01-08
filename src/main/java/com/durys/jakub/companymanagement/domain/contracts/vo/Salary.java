package com.durys.jakub.companymanagement.domain.contracts.vo;

import com.durys.jakub.companymanagement.commons.vo.Currency;
import com.durys.jakub.companymanagement.commons.vo.Money;

import java.math.BigDecimal;

public class Salary {

    private final Money amount;
    private final Currency currency;

    public Salary(Money amount, Currency currency) {
       this.amount = amount;
       this.currency = currency;
    }

    public static Salary withDefaultCurrencyOf(BigDecimal amount) {
        return new Salary(new Money(amount), Currency.EURO);
    }


}
