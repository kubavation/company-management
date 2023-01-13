package com.durys.jakub.companymanagement.domain.employees.model.vo;

import lombok.*;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode
class FirstName {
    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
