package com.durys.jakub.companymanagement.domain.employees.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@EqualsAndHashCode
public class EmployeeId implements Serializable {
    protected final UUID id;

    public static EmployeeId from(UUID id) {
        return new EmployeeId(id);
    }
}
