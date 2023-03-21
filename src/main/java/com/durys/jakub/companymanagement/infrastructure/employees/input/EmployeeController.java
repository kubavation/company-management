package com.durys.jakub.companymanagement.infrastructure.employees.input;

import com.durys.jakub.companymanagement.application.employees.commands.ChangeEmployeePersonalDataCommand;
import com.durys.jakub.companymanagement.application.employees.commands.EngageEmployeeCommand;
import com.durys.jakub.companymanagement.cqrs.commands.CommandGateway;
import com.durys.jakub.companymanagement.infrastructure.employees.input.model.EmployeeDTO;
import com.durys.jakub.companymanagement.infrastructure.employees.input.model.EmployeePersonalDataDTO;
import com.durys.jakub.companymanagement.readmodel.employees.EmployeeFinder;
import com.durys.jakub.companymanagement.readmodel.employees.EmployeeWithPersonalData;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/employees")
@ApiOperation("Employee API")
class EmployeeController {

    private final CommandGateway commandGateway;
    private final EmployeeFinder employeeFinder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Engage employee")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Employee successfully engaged")
    })
    void engageEmployee(@ApiParam("Employee") @RequestBody EmployeeDTO employee) {

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
    @ApiOperation(value = "Change employee personal data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Personal data successfully changed")
    })
    void changePersonalData(@ApiParam("Id of employee") @PathVariable UUID employeeId,
               @ApiParam("Personal data") @RequestBody EmployeePersonalDataDTO personalData) {

        log.info("change personal data for employeeId: {}", employeeId);

        commandGateway.dispatch(
                new ChangeEmployeePersonalDataCommand(
                        employeeId, personalData.getFirstName(), personalData.getLastName(),
                        personalData.getGender(), personalData.getBirthdayDate()
                )
        );
    }

    
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Employees with personal data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Personal data successfully changed")
    })
    ResponseEntity<Collection<EmployeeWithPersonalData>> employeesWithPersonalData() {
        return ResponseEntity.ok(employeeFinder.findEmployeesWithPersonalData(null));
    }

}
