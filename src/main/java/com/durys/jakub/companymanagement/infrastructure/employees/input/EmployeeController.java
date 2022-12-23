package com.durys.jakub.companymanagement.infrastructure.employees.input;

import com.durys.jakub.companymanagement.application.employees.EmployeesApplicationService;
import com.durys.jakub.companymanagement.infrastructure.employees.input.model.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeesApplicationService employeesApplicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody EmployeeDTO employeeDTO) {
        employeesApplicationService.employ(employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getGender());
    }
}
