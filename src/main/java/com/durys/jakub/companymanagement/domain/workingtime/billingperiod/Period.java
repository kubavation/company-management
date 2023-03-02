package com.durys.jakub.companymanagement.domain.workingtime.billingperiod;

import java.time.LocalDate;

public record Period(LocalDate from, LocalDate to) {}