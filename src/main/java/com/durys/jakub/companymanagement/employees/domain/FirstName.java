package com.durys.jakub.companymanagement.employees.domain;

import lombok.*;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode
class FirstName {
    private final String value;
}
