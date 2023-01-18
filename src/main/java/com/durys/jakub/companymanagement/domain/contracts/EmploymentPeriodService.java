package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

@DomainService
@AllArgsConstructor
public class EmploymentPeriodService {

    private final ContractRepository contractRepository;

    @RequiredArgsConstructor
    public enum EmploymentPeriodMeasure {
        MONTHS(days -> days / 30), //todo fix
        YEARS(days -> days / 365); //todo fix

        private final Function<Long, Long> extractor;
    }

    public Long employmentPeriod(EmployeeId employeeId) {
        return loadContractDaysPeriod(employeeId)
                .reduce(0L, Long::sum);
    }

    public Long employmentPeriod(EmployeeId employeeId, EmploymentPeriodMeasure measure) {
        return loadContractDaysPeriod(employeeId)
                .map(measure.extractor)
                .reduce(0L, Long::sum);
    }


    private Stream<Long> loadContractDaysPeriod(EmployeeId employeeId) {
        return contractRepository.loadBy(employeeId)
                .stream()
                .filter(EmploymentContract.class::isInstance)
                .sorted(Comparator.comparing(contract -> contract.period.from()))
                .map(this::toDays);
    }

    private long toDays(Contract contract) {
        return ChronoUnit.DAYS.between(
                contract.period.from(),
                Objects.requireNonNullElse(contract.period.to(), LocalDate.now())) + 1; //inclusive now
    }

}
