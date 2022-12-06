package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LeaveRequestPeriodTest {


    @Test
    void createLeaveRequestPeriod_shouldCreate() {
        LocalDateTime currentDate = LocalDateTime.now();
        LeaveRequestPeriod leaveRequestPeriod = new LeaveRequestPeriod(currentDate, currentDate);
        assertEquals(1, leaveRequestPeriod.numberOfDays());
    }

    @Test
    void createLeaveRequestPeriod_shouldThrowInvalidLeaveRequestPeriodException() {
        LocalDateTime currentDate = LocalDateTime.now();
        assertThrows(InvalidLeaveRequestPeriodException.class, () -> new LeaveRequestPeriod(currentDate, currentDate.minusSeconds(1)));
    }

}