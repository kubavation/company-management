package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.domain.contracts.employment.EmploymentContract;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.AllArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.Set;

@DomainService
@AllArgsConstructor
public class EmploymentService {

    private final ContractRepository contractRepository;

    public Integer employmentPeriod(EmployeeId employeeId) {
        Set<Contract> contracts = contractRepository.loadBy(employeeId);
        return contracts.stream()
                .filter(contract -> contract instanceof EmploymentContract)
                .sorted(Comparator.comparing(contract -> contract.period.from()))
                .map(contract -> Period.between(contract.period.from(), contract.period.to()).getDays())
                .reduce(0, Integer::sum)
                .intValue();
    }
}
