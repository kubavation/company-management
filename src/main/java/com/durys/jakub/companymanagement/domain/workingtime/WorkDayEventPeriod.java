package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.sharedkernel.util.RangeValidators;
import lombok.NonNull;

import java.time.LocalTime;

public record WorkDayEventPeriod(LocalTime from, LocalTime to) {

    public WorkDayEventPeriod(@NonNull LocalTime from, @NonNull LocalTime to) {

        RangeValidators.comparing(LocalTime.class)
                .validate(from, to);

        this.from = from;
        this.to = to;
    }
}
