package com.durys.jakub.companymanagement.infrastructure.employees.input;

import com.durys.jakub.companymanagement.application.employees.commands.EngageEmployeeCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import com.durys.jakub.companymanagement.infrastructure.employees.input.model.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
class EmployeeController {

    private final CommandGateway commandGateway;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void engageEmployee(@RequestBody EmployeeDTO employee) {
        commandGateway.dispatch(
                new EngageEmployeeCommand(
                        employee.getFirstName(), employee.getLastName(),
                        employee.getGender(), employee.getBirthdayDate(), employee.getStructureId()));
    }

}
