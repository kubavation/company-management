package com.durys.jakub.companymanagement.infrastructure.employees.input;

import com.durys.jakub.companymanagement.application.employees.commands.ChangeEmployeePersonalDataCommand;
import com.durys.jakub.companymanagement.application.employees.commands.EngageEmployeeCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import com.durys.jakub.companymanagement.infrastructure.employees.input.model.EmployeeDTO;
import com.durys.jakub.companymanagement.infrastructure.employees.input.model.EmployeePersonalDataDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/employees")
@RequiredArgsConstructor
class EmployeeController {

    private final CommandGateway commandGateway;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void engageEmployee(@RequestBody EmployeeDTO employee) {

        log.info("calling engage employee");

        commandGateway.dispatch(
                new EngageEmployeeCommand(
                        employee.getPersonalData().getFirstName(),
                        employee.getPersonalData().getLastName(),
                        employee.getPersonalData().getGender(),
                        employee.getPersonalData().getBirthdayDate(),
                        employee.getDepartmentId()));
    }

    @PutMapping("/{employeeId}/personal-data")
    @ResponseStatus(HttpStatus.OK)
    public void changePersonalData(@PathVariable UUID employeeId, @RequestBody EmployeePersonalDataDTO personalData) {

        log.info("change personal data for employeeId: {}", employeeId);

        commandGateway.dispatch(
                new ChangeEmployeePersonalDataCommand(
                        employeeId, personalData.getFirstName(), personalData.getLastName(),
                        personalData.getGender(), personalData.getBirthdayDate()
                )
        );
    }

}
