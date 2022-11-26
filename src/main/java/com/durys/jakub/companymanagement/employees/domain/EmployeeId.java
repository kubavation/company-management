package com.durys.jakub.companymanagement.employees.domain;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode
public class EmployeeId implements Serializable {
    private final UUID id;
}
