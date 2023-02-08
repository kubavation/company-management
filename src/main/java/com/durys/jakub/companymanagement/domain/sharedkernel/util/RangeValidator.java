package com.durys.jakub.companymanagement.domain.sharedkernel.util;

import java.time.temporal.Temporal;

public interface RangeValidator<T extends Temporal> {
    void validate(T from, T to);
}
