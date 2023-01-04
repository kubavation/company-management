package com.durys.jakub.companymanagement.application.contracts.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class AssignContractCommand implements Command {

    private final UUID employeeId;
    private final String contractNumber;
    private final String position;

    private final BigDecimal salary;
    private final BigDecimal salaryCurrency;

    private final String billingPeriod;
    private final String dailyHourNumber;
    private final String contractType;
}
