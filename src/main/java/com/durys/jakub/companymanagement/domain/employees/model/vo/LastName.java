package com.durys.jakub.companymanagement.domain.employees.model.vo;

import lombok.*;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode
class LastName {

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
