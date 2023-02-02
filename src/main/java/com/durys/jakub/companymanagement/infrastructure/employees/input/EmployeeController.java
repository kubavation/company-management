package com.durys.jakub.companymanagement.infrastructure.employees.input;

import com.durys.jakub.companymanagement.application.employees.commands.EngageEmployeeCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import com.durys.jakub.companymanagement.infrastructure.employees.input.model.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
