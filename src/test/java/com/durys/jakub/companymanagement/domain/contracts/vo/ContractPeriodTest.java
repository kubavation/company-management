package com.durys.jakub.companymanagement.domain.contracts.vo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ContractPeriodTest {

    @Test
    void createContractPeriod_shouldCreateNewInstance() {
        assertDoesNotThrow(() -> new ContractPeriod(ContractPeriodType.FIXED_TERM,
                LocalDate.of(2000, Month.JANUARY, 1),
                LocalDate.of(2001, Month.JANUARY, 1)));
    }
}