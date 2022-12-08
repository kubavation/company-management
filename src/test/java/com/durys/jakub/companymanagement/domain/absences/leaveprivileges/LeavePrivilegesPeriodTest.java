package com.durys.jakub.companymanagement.domain.absences.leaveprivileges;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.exception.InvalidLeavePrivilegesPeriodException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LeavePrivilegesPeriodTest {


    @Test
    void createLeavePrivilegesPeriod_shouldCreate() {
        assertDoesNotThrow(() -> new LeavePrivilegesPeriod(LocalDate.now(), LocalDate.now().plusDays(1)));
    }

    @Test
    void createLeavePrivilegesPeriod_shouldThrowInvalidLeavePrivilegesPeriodException() {
        assertThrows(InvalidLeavePrivilegesPeriodException.class, () -> new LeavePrivilegesPeriod(LocalDate.now(), LocalDate.now().minusDays(1)));
    }

}