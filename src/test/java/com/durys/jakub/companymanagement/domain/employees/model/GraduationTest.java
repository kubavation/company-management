package com.durys.jakub.companymanagement.domain.employees.model;

import com.durys.jakub.companymanagement.domain.sharedkernel.util.DateRangeValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class GraduationTest {

    @Test
    void createGraduation_shouldSuccessfullyCreate() {

        assertDoesNotThrow(
                () -> new Graduation("Secondary school",
                LocalDate.now(), LocalDate.now().plusYears(1),
                Graduation.Type.SECONDARY));
    }

    @Test
    void createGraduation_withInvalidDateRange_shouldThrowInvalidDateRangeException() {

        assertThrows(
                DateRangeValidator.InvalidDateRangeException.class,
                () -> new Graduation("Secondary school",
                        LocalDate.now(), LocalDate.now().minusYears(1),
                        Graduation.Type.SECONDARY));
    }
}