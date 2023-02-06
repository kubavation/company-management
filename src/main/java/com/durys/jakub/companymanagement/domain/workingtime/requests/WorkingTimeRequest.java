package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class WorkingTimeRequest {
    private final WorkingTimeRequestId requestId;
    private final LocalDate atDay;
    private final WorkingTimeRequestPeriod period;
}
