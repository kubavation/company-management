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
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now();
        LeaveRequestPeriod leaveRequestPeriod = LeaveRequestDailyPeriod.of(date1, date2);
        assertEquals(BigDecimal.ONE, leaveRequestPeriod.quantity());
    }

    @Test
    void getLeaveRequestHourlyPeriodNumberOfHours_shouldReturn2Hour() {
        LocalDateTime date1 = LocalDate.now().atTime(LocalTime.of(8,0));
        LocalDateTime date2 = LocalDate.now().atTime(LocalTime.of(10,0));
        LeaveRequestPeriod leaveRequestPeriod = LeaveRequestHourlyPeriod.of(date1, date2);
        assertEquals(BigDecimal.valueOf(2), leaveRequestPeriod.quantity());
    }

}