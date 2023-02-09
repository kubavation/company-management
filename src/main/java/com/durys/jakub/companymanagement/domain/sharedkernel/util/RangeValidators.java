package com.durys.jakub.companymanagement.domain.sharedkernel.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.time.temporal.Temporal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RangeValidators {

    public static <T extends Temporal> RangeValidator<T> comparing(@NonNull Class<T> clazz) {
        return new RangeValidator<>(clazz);
    }

}
