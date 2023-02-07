package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.sharedkernel.util.TimeRangeValidator;
import lombok.NonNull;

import java.time.LocalTime;

class WorkingTimeRequestPeriod {

    private final LocalTime from;
    private final LocalTime to;

    public WorkingTimeRequestPeriod(@NonNull LocalTime from, @NonNull LocalTime to) {
        TimeRangeValidator.of(from, to).validate();
        this.from = from;
        this.to = to;
    }

}
