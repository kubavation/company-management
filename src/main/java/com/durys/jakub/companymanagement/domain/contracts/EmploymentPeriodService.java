package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.Period;
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
        MONTHS(days -> Period.ofDays(days).getMonths()),
        YEARS(days -> Period.ofDays(days).getYears());

        private final Function<Integer, Integer> extractor;
    }

    public Integer employmentPeriod(EmployeeId employeeId) {
        return loadContractDaysPeriod(employeeId)
                .reduce(0, Integer::sum);
    }

    public Integer employmentPeriod(EmployeeId employeeId, EmploymentPeriodMeasure measure) {
        return loadContractDaysPeriod(employeeId)
                .map(measure.extractor)
                .reduce(0, Integer::sum);
    }


    private Stream<Integer> loadContractDaysPeriod(EmployeeId employeeId) {
        return contractRepository.loadBy(employeeId)
                .stream()
                .filter(EmploymentContract.class::isInstance)
                .sorted(Comparator.comparing(contract -> contract.period.from()))
                .map(this::toDays);
    }

    private int toDays(Contract contract) {
        return Period.between(
                contract.period.from(),
                Objects.requireNonNullElse(contract.period.to(), LocalDate.now())).getDays();
    }

}
