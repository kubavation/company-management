package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.exception.InvalidLeavePrivilegesPeriodException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestPeriod;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LeavePrivilegePeriodTest {


    @Test
    void createLeavePrivilegesPeriod_shouldCreate() {
        assertDoesNotThrow(() -> new LeavePrivilegesPeriod(LocalDate.now(), LocalDate.now().plusDays(1)));
    }

    @Test
    void createLeavePrivilegesPeriod_shouldThrowInvalidLeavePrivilegesPeriodException() {
        assertThrows(InvalidLeavePrivilegesPeriodException.class, () -> new LeavePrivilegesPeriod(LocalDate.now(), LocalDate.now().minusDays(1)));
    }

    @Test
    void isInPrevileges_shouldReturnTrueWhenDateIsInPeriod() {
        LeavePrivilegesPeriod period =  new LeavePrivilegesPeriod(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertTrue(period.isInPeriod(LocalDate.now()));
    }

    @Test
    void isInPrevileges_shouldReturnFaleWhenDateIsNotInPeriod() {
        LeavePrivilegesPeriod period =  new LeavePrivilegesPeriod(LocalDate.now().minusDays(1), LocalDate.now().plusDays(1));
        assertFalse(period.isInPeriod(LocalDate.now().minusDays(2)));
    }

}