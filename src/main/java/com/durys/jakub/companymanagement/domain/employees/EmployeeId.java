package com.durys.jakub.companymanagement.domain.employees;

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
