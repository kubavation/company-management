package com.durys.jakub.companymanagement.domain.sharedkernel.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Supplier;


@AllArgsConstructor
@Getter
public enum RangeType {
    TIME(TimeRangeValidator::new),
    DATE(DateRangeValidator::new);

    private final Supplier<RangeValidator<?>> instance;
}
