package com.durys.jakub.companymanagement.infrastructure.departments;

import com.durys.jakub.companymanagement.domain.employees.model.vo.DepartmentId;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.Department;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.DepartmentProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;


@RequiredArgsConstructor
public class RestDepartmentProvider implements DepartmentProvider {

    private final WebClient webClient;

    //todo converter

    @Override
    public Department find(DepartmentId departmentId) {
        return webClient.get().retrieve().toEntity(Department.class).block().getBody(); //todo
    }
}