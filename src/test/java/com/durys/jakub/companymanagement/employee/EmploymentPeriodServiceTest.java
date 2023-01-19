package com.durys.jakub.companymanagement.employee;

import com.durys.jakub.companymanagement.domain.contracts.Contract;
import com.durys.jakub.companymanagement.domain.contracts.ContractRepository;
import com.durys.jakub.companymanagement.domain.contracts.ContractType;
import com.durys.jakub.companymanagement.domain.contracts.employment.fixedterm.FixedTermEmployeeContract;
import com.durys.jakub.companymanagement.domain.contracts.employment.permanent.PermanentEmployeeContract;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;
import com.durys.jakub.companymanagement.domain.employees.model.EmploymentPeriodService;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.vo.DepartmentId;
import com.durys.jakub.companymanagement.domain.employees.model.vo.PersonalData;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.Department;
import com.durys.jakub.companymanagement.infrastructure.contracts.out.JdbcContractRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmploymentPeriodServiceTest {


    private ContractRepository contractRepository = Mockito.mock(JdbcContractRepository.class);

    private EmploymentPeriodService employmentPeriodService = new EmploymentPeriodService(contractRepository);

    @Test
    void employmentPeriod_with2FixedTermContracts_shouldReturnCorrectEmploymentPeriodInDays() {

        EmployeeId employeeId = new EmployeeId(UUID.randomUUID());
        Employee employee = employee(employeeId);
        LocalDate from = LocalDate.of(2022, 1, 1);
        LocalDate to = LocalDate.of(2022, 2, 25);

        long expectedDays = ChronoUnit.DAYS.between(from, to) + 1;
        long expectedMonths = ChronoUnit.MONTHS.between(from, to);
        long expectedYears = ChronoUnit.YEARS.between(from, to);

        Set<Contract> contracts = Set.of(
            new FixedTermEmployeeContract(
                  Contract.Builder.instanceOf(ContractType.EMPLOYMENT_FIXED_TERM)
                          .in(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 31))
                          .withData(contractData())
                          .assignTo(employee)),
            new FixedTermEmployeeContract(
                    Contract.Builder.instanceOf(ContractType.EMPLOYMENT_FIXED_TERM)
                            .in(LocalDate.of(2022, 2, 1), LocalDate.of(2022, 2, 25))
                            .withData(contractData())
                            .assignTo(employee))
          );


        Mockito.when(contractRepository.loadBy(employeeId)).thenReturn(contracts);

        EmploymentPeriodService.EmploymentPeriod result = employmentPeriodService.employmentPeriod(employeeId);
        assertEquals(expectedDays, result.getDays());
        assertEquals(expectedMonths, result.getMonths());
        assertEquals(expectedYears, result.getYears());
    }

    @Test
    void employmentPeriod_withFixedAndPermanentContract_shouldReturnCorrectEmploymentPeriodInDays() {

        EmployeeId employeeId = new EmployeeId(UUID.randomUUID());
        Employee employee = employee(employeeId);
        LocalDate from = LocalDate.of(2022, 1, 1);
        LocalDate to = LocalDate.now();


        long expectedDays = ChronoUnit.DAYS.between(from, to) + 1;
        long expectedMonths = ChronoUnit.MONTHS.between(from, to);
        long expectedYears = ChronoUnit.YEARS.between(from, to);

        Set<Contract> contracts = Set.of(
                new FixedTermEmployeeContract(
                        Contract.Builder.instanceOf(ContractType.EMPLOYMENT_FIXED_TERM)
                                .in(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 31))
                                .withData(contractData())
                                .assignTo(employee)),
                new PermanentEmployeeContract(
                        Contract.Builder.instanceOf(ContractType.EMPLOYMENT_PERMANENT)
                                .from(LocalDate.of(2022, 2, 1))
                                .withData(contractData())
                                .assignTo(employee))
        );


        Mockito.when(contractRepository.loadBy(employeeId)).thenReturn(contracts);

        EmploymentPeriodService.EmploymentPeriod result = employmentPeriodService.employmentPeriod(employeeId);
        assertEquals(expectedDays, result.getDays());
        assertEquals(expectedMonths, result.getMonths());
        assertEquals(expectedYears, result.getYears());
    }

    private ContractData contractData() {
        return new ContractData("IT Expert", BigDecimal.valueOf(5000), 8,0);
    }

    private Employee employee(EmployeeId employeeId) {
        return new Employee(
                employeeId,
                new PersonalData("Jacob", "Wall", "MAN", LocalDate.of(1990, 1, 1)),
                new Department(new DepartmentId(UUID.randomUUID().toString()), "Department 1", "D1", "D1"),
                Collections.emptyList());
    }

}