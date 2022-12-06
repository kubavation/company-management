package com.durys.jakub.companymanagement.domain.absences.leaverequests;


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

}