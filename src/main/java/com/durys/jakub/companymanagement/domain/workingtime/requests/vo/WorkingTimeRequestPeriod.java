package com.durys.jakub.companymanagement.domain.workingtime.requests.vo;

import com.durys.jakub.companymanagement.domain.sharedkernel.util.RangeValidators;
import lombok.NonNull;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public record WorkingTimeRequestPeriod(LocalTime from, LocalTime to) {

    public WorkingTimeRequestPeriod(@NonNull LocalTime from, @NonNull LocalTime to) {

        RangeValidators
                .comparing(LocalTime.class)
                .validate(from, to);

        this.from = from;
        this.to = to;
    }

    public Long minutes() {
        return ChronoUnit.MINUTES.between(from, to);
    }

}
