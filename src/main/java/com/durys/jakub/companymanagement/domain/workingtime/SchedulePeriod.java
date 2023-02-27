package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.sharedkernel.util.RangeValidators;
import lombok.NonNull;

import java.time.Duration;
import java.time.LocalTime;

public record SchedulePeriod(LocalTime from, LocalTime to) {

    public SchedulePeriod(@NonNull LocalTime from, @NonNull LocalTime to) {

        RangeValidators.comparing(LocalTime.class)
                .validate(from, to);

        this.from = from;
        this.to = to;
    }

    public Duration duration() {
        return Duration.between(from, to);
    }


}
