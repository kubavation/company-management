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
        assertDoesNotThrow(() -> new LeaveRequestDailyPeriod(currentDate, currentDate));
    }

    @Test
    void createLeaveRequestPeriod_shouldThrowInvalidLeaveRequestPeriodException() {
        LocalDate currentDate = LocalDate.now();
        assertThrows(InvalidLeaveRequestPeriodException.class, () -> new LeaveRequestDailyPeriod(currentDate, currentDate.minusDays(1)));
    }

    @Test
    void createLeaveRequestPeriod_shouldThrowShouldThrowExceptionWhenDateFromIsNull() {
        assertThrows(RuntimeException.class,
                () -> new LeaveRequestDailyPeriod(null, LocalDate.now()));
    }

    @Test
    void createLeaveRequestPeriod_shouldThrowShouldThrowExceptionWhenDateToIsNull() {
        assertThrows(RuntimeException.class,
                () -> new LeaveRequestDailyPeriod(LocalDate.now(), null));
    }

    @Test
    void getLeaveRequestDailyPeriodNumberOfDays_shouldReturn1Day() {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now();
        LeaveRequestPeriod leaveRequestPeriod = new LeaveRequestDailyPeriod(date1, date2);
        assertEquals(BigDecimal.ONE, leaveRequestPeriod.quantity());
    }

    @Test
    void getLeaveRequestHourlyPeriodNumberOfHours_shouldReturn2Hour() {
        LocalDateTime date1 = LocalDate.now().atTime(LocalTime.of(8,0));
        LocalDateTime date2 = LocalDate.now().atTime(LocalTime.of(10,0));
        LeaveRequestPeriod leaveRequestPeriod = new LeaveRequestHourlyPeriod(date1, date2);
        assertEquals(BigDecimal.valueOf(2), leaveRequestPeriod.quantity());
    }

}