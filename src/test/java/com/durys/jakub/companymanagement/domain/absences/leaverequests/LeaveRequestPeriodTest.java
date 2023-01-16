package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjuster;

import static org.junit.jupiter.api.Assertions.*;

class LeaveRequestPeriodTest {


    @Test
    void createLeaveRequestPeriod_shouldCreate() {
        LocalDate currentDate = LocalDate.now();
        assertDoesNotThrow(() -> LeaveRequestDailyPeriod.of(currentDate, currentDate));
    }

    @Test
    void createLeaveRequestPeriod_shouldThrowInvalidLeaveRequestPeriodException() {
        LocalDate currentDate = LocalDate.now();
        assertThrows(InvalidLeaveRequestPeriodException.class, () -> LeaveRequestDailyPeriod.of(currentDate, currentDate.minusDays(1)));
    }

    @Test
    void createLeaveRequestPeriod_shouldThrowShouldThrowExceptionWhenDateFromIsNull() {
        Exception exception = assertThrows(RuntimeException.class,
                () -> LeaveRequestDailyPeriod.of(null, LocalDate.now()));

        assertEquals("Date from value not provided", exception.getMessage());
    }

    @Test
    void createLeaveRequestPeriod_shouldThrowShouldThrowExceptionWhenDateToIsNull() {
        Exception exception = assertThrows(RuntimeException.class,
                () -> LeaveRequestDailyPeriod.of(LocalDate.now(), null));

        assertEquals("Date from value not provided", exception.getMessage());
    }

    @Test
    void getLeaveRequestDailyPeriodNumberOfDays_shouldReturn1Day() {
        LocalDate from = LocalDate.now();
        LocalDate to = LocalDate.now();
        LeaveRequestPeriod leaveRequestPeriod = LeaveRequestDailyPeriod.of(from, to);
        assertEquals(BigDecimal.ONE, leaveRequestPeriod.quantity());
    }

    @Test
    void getLeaveRequestHourlyPeriodNumberOfHours_shouldReturn2Hour() {
        LocalDateTime from = ofTime(8, 0);
        LocalDateTime to = ofTime(10, 0);
        LeaveRequestPeriod leaveRequestPeriod = LeaveRequestHourlyPeriod.of(from, to);
        assertEquals(BigDecimal.valueOf(2), leaveRequestPeriod.quantity());
    }



    private static LocalDateTime ofTime(int hour, int minute) {
        return LocalDate.now().atTime(LocalTime.of(hour, minute));
    }

}