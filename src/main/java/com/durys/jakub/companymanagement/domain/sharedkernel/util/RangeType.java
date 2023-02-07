package com.durys.jakub.companymanagement.domain.sharedkernel.util;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;

@AllArgsConstructor
public enum RangeType {
    TIME(LocalTime.class),
    DATE(LocalDate.class),
    DATETIME(LocalDateTime.class);

    private final Class<? extends Temporal> clazz;
}
