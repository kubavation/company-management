package com.durys.jakub.companymanagement.application.contracts.commands;

import com.durys.jakub.companymanagement.cqrs.commands.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record AssignContractCommand(UUID employeeId, String contractNumber, String position, BigDecimal salary,
                                    BigDecimal salaryCurrency, String billingPeriod, String contractType,
                                    int dailyNumberOfHours, int dailyNumberOfMinutes, LocalDate from,
                                    LocalDate to) implements Command {

}
