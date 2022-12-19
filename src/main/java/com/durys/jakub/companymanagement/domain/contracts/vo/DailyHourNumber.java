package com.durys.jakub.companymanagement.domain.contracts.vo;

import java.time.LocalTime;

class DailyHourNumber {
    private final LocalTime value;

    private DailyHourNumber(LocalTime value) {
        this.value = value;
    }

    public static DailyHourNumber of(int hours, int minutes) {
        return new DailyHourNumber(LocalTime.of(hours, minutes));
    }
}
