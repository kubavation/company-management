package com.durys.jakub.companymanagement.domain.contracts.vo;

import com.durys.jakub.companymanagement.commons.vo.Currency;
import com.durys.jakub.companymanagement.commons.vo.Money;

class Salary {

    private final Money amount;
    private final Currency currency;

    Salary(Money amount, Currency currency) {
       this.amount = amount;
       this.currency = currency;
    }
}
