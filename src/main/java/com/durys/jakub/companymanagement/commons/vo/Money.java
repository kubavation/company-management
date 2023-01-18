package com.durys.jakub.companymanagement.commons.vo;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;

import java.math.BigDecimal;

@ValueObject
public class Money {
    private final BigDecimal amount;
    public Money(BigDecimal amount) {

        if (BigDecimal.ZERO.compareTo(amount) >= 0) {
            throw new IllegalArgumentException();
        }

        this.amount = amount;
    }
}
