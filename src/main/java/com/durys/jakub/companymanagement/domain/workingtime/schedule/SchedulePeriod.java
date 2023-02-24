package com.durys.jakub.companymanagement.domain.workingtime.schedule;

import com.durys.jakub.companymanagement.domain.sharedkernel.util.RangeValidators;
import lombok.NonNull;

import java.time.LocalTime;

public class SchedulePeriod {

    private final LocalTime from;
    private final LocalTime to;

    public SchedulePeriod(@NonNull LocalTime from, @NonNull LocalTime to) {

        RangeValidators.comparing(LocalTime.class)
                .validate(from, to);

        this.from = from;
        this.to = to;
    }

    public LocalTime from() {
        return from;
    }

    public LocalTime to() {
        return to;
    }


}
