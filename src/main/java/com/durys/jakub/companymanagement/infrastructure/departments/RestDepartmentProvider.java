package com.durys.jakub.companymanagement.infrastructure.departments;

import com.durys.jakub.companymanagement.domain.employees.model.vo.DepartmentId;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.Department;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.DepartmentProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;


@RequiredArgsConstructor
@Slf4j
public class RestDepartmentProvider implements DepartmentProvider {

    private final WebClient webClient;

    private record StructureEntry(String structureId, String name, String shortcut, String path) {
        Department toDepartment() {
            return new Department(new DepartmentId(structureId), name, shortcut, path);
        }
    }


    @Override
    public Department find(DepartmentId departmentId) {
        log.info("calling external resource with {}", departmentId);

        return webClient
                .get()
                .uri("/" + departmentId.value())
                .retrieve()
                .toEntity(StructureEntry.class)
                .block().getBody()
                .toDepartment();
    }

}
