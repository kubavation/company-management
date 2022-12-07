package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjuster;

import static org.junit.jupiter.api.Assertions.*;

class LeaveRequestPeriodTest {


    @Test
    void createLeaveRequestPeriod_shouldCreate() {
        LocalDateTime currentDate = LocalDateTime.now();
        assertDoesNotThrow(() -> new LeaveRequestPeriod(currentDate, currentDate));
    }

    @Test
    void createLeaveRequestPeriod_shouldThrowInvalidLeaveRequestPeriodException() {
        LocalDateTime currentDate = LocalDateTime.now();
        assertThrows(InvalidLeaveRequestPeriodException.class, () -> new LeaveRequestPeriod(currentDate, currentDate.minusSeconds(1)));
    }

    @Test
    void createLeaveRequestPeriod_shouldThrowShouldThrowExceptionWhenDateFromIsNull() {
        assertThrows(RuntimeException.class,
                () -> new LeaveRequestPeriod(null, LocalDateTime.now()));
    }

    @Test
    void createLeaveRequestPeriod_shouldThrowShouldThrowExceptionWhenDateToIsNull() {
        assertThrows(RuntimeException.class,
                () -> new LeaveRequestPeriod(LocalDateTime.now(), null));
    }

    @Test
    void getLeaveRequestPeriodNumberOfDays_shouldReturn1Day() {
        LocalDateTime date1 = LocalDate.now().atTime(LocalTime.of(8,0));
        LocalDateTime date2 = LocalDate.now().atTime(LocalTime.of(16,0));
        LeaveRequestPeriod leaveRequestPeriod = new LeaveRequestPeriod(date1, date2);
        assertEquals(1, leaveRequestPeriod.numberOfDays());
    }

}