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

}