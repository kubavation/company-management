package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class RequestInformation {
    private final LocalDate atDay;
    private final WorkingTimeRequestPeriod period;

    public RequestInformation(@NonNull LocalDate atDay, @NonNull LocalTime from, @NonNull LocalTime to) {
        this.atDay = atDay;
        this.period = new WorkingTimeRequestPeriod(from, to);
    }
}
