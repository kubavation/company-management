package com.durys.jakub.companymanagement.domain.contracts.vo;

import java.time.LocalTime;
import java.time.temporal.TemporalAdjuster;

public class DailyHourNumber {
    private final LocalTime value;

    private DailyHourNumber(LocalTime value) {
        this.value = value;
    }

    public static DailyHourNumber of(int hours, int minutes) {

        if (hours < 0 || minutes < 0) {
            throw new IllegalArgumentException();
        }

        return new DailyHourNumber(LocalTime.of(hours, minutes));
    }

    public LocalTime value() {
        return value;
    }

}
