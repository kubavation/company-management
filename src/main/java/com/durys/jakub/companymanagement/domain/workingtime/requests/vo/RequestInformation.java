package com.durys.jakub.companymanagement.domain.workingtime.requests.vo;

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

    public RequestInformation(@NonNull LocalDate atDay, @NonNull WorkingTimeRequestPeriod period) {
        this.atDay = atDay;
        this.period = period;
    }

    public WorkingTimeRequestPeriod period() {
        return period;
    }

    public LocalTime from() {
        return period.from();
    }

    public LocalTime to() {
        return period.to();
    }

    public LocalDate atDay() {
        return atDay;
    }
}
