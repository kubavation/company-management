package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
class WorkingTimeRequestPeriod {
    private LocalTime from;
    private LocalDate to;
}