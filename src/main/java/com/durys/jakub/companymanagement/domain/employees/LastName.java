package com.durys.jakub.companymanagement.domain.employees;

import lombok.*;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode
class LastName {
    private final String value;
}