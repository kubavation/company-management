package com.durys.jakub.companymanagement.domain.employees.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class EmployeeId implements Serializable {

    protected final UUID value;

    public static EmployeeId from(UUID value) {
        return new EmployeeId(value);
    }
}
