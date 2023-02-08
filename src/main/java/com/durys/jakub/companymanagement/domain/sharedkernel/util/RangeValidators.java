package com.durys.jakub.companymanagement.domain.sharedkernel.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RangeValidators {

    public static RangeValidator<?> of(@NonNull RangeType type) {
        return type.getInstance().get();
    }

}
