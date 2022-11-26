package com.durys.jakub.companymanagement.employees.domain;

import lombok.*;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode
class LastName {
    private final String value;
}
