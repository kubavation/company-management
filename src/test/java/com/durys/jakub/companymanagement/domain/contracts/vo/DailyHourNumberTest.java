package com.durys.jakub.companymanagement.domain.contracts.vo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DailyHourNumberTest {

    @Test
    void createDailyHourNumber_shouldSuccessfullyCreateObject() {
        DailyHourNumber object = DailyHourNumber.of(8,0);
        assertEquals(LocalTime.of(8, 0), object.value());
    }

    @Test
    void createDailyHourNumber_shouldThrowIllegalArgumentException_WhenNumberOfHoursIsSmallerThan0() {
        assertThrows(IllegalAccessException.class, () -> DailyHourNumber.of(-1,0));
    }

    @Test
    void createDailyHourNumber_shouldThrowIllegalArgumentException_WhenNumberOfMinutesIsSmallerThan0() {
        assertThrows(IllegalAccessException.class, () -> DailyHourNumber.of(1,-1));
    }
}