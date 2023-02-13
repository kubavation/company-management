package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.sharedkernel.util.RangeValidators;
import lombok.NonNull;

import java.time.LocalTime;

public record WorkingTimeRequestPeriod(LocalTime from, LocalTime to) {

    public WorkingTimeRequestPeriod(@NonNull LocalTime from, @NonNull LocalTime to) {

        RangeValidators
                .comparing(LocalTime.class)
                .validate(from, to);

        this.from = from;
        this.to = to;
    }

}
