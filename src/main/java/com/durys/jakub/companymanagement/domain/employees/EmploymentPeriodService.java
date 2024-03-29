package com.durys.jakub.companymanagement.domain.employees;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractRepository;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

@DomainService
@AllArgsConstructor
public class EmploymentPeriodService {

    private final ContractRepository contractRepository;


    @Getter
    public static class EmploymentPeriod {
        final long days;
        final long months;
        final long years;

        private EmploymentPeriod(long days, long months, long years) {
            this.days = days;
            this.months = months;
            this.years = years;
        }

        private static EmploymentPeriod from(long days) {
            return new EmploymentPeriod(days,
                EmploymentPeriodMeasure.MONTHS.extractor.apply(days),
                EmploymentPeriodMeasure.YEARS.extractor.apply(days)
            );
        }

    }

    @RequiredArgsConstructor
    enum EmploymentPeriodMeasure {
        MONTHS(days -> days / 30),
        YEARS(days -> days / 365);

        private final Function<Long, Long> extractor;
    }

    public EmploymentPeriod employmentPeriod(EmployeeId employeeId) {
        return EmploymentPeriod.from(
                    loadContractDaysPeriod(employeeId)
                        .reduce(0L, Long::sum));
    }


    private Stream<Long> loadContractDaysPeriod(EmployeeId employeeId) {
        return contractRepository.loadBy(employeeId)
                .stream()
                .filter(EmploymentContract.class::isInstance)
                .sorted(Comparator.comparing(Contract::validFrom))
                .map(this::toDays);
    }

    private long toDays(Contract contract) {
        return ChronoUnit.DAYS.between(
                contract.validFrom(),
                Objects.requireNonNullElse(contract.validTo(), LocalDate.now())) + 1; //inclusive now
    }

}
