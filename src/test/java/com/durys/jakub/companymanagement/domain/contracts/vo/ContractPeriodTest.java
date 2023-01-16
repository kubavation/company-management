package com.durys.jakub.companymanagement.domain.contracts.vo;

import com.durys.jakub.companymanagement.domain.contracts.employment.fixedterm.FixedTermEmployeeContractPeriod;
import com.durys.jakub.companymanagement.domain.contracts.exception.ContractPeriodEndDateNotDefinedException;
import com.durys.jakub.companymanagement.domain.contracts.exception.InvalidContractPeriodException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ContractPeriodTest {

    @Test
    void createContractPeriod_shouldCreateNewInstance() {
        assertDoesNotThrow(() -> new FixedTermEmployeeContractPeriod(
                LocalDate.of(2000, Month.JANUARY, 1),
                LocalDate.of(2001, Month.JANUARY, 1)));
    }


    @Test
    void createContractPeriod_shouldThrowException_whenInvalidDatesPeriod() {

        LocalDate from = LocalDate.of(2001, Month.JANUARY, 1);
        LocalDate to = LocalDate.of(2000, Month.JANUARY, 1);

        assertThrows(InvalidContractPeriodException.class, () -> new FixedTermEmployeeContractPeriod(from, to));
    }

    @Test
    void createContractPeriod_shouldThrowException_whenDateFromIsNotDefined() {

        LocalDate from = null;
        LocalDate to = LocalDate.of(2001, Month.JANUARY, 1);

        Exception exception = assertThrows(RuntimeException.class, () -> new FixedTermEmployeeContractPeriod(from, to));

        assertEquals("invalid date from param", exception.getMessage());
    }

    @Test
    void createContractPeriod_shouldThrowException_whenDateToIsNotDefinedAndTypeRequiresDateTo() {

        LocalDate from = LocalDate.of(2001, Month.JANUARY, 1);
        LocalDate to = null;

        assertThrows(RuntimeException.class, () -> new FixedTermEmployeeContractPeriod(from, to));
    }

}