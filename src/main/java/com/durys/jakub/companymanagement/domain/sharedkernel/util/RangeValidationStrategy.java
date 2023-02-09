package com.durys.jakub.companymanagement.domain.sharedkernel.util;

interface RangeValidationStrategy<T> {
    void validate(T from, T to);
}
