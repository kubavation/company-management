package com.durys.jakub.companymanagement.crud.personal_request.model.enums;

import com.durys.jakub.companymanagement.crud.personal_request.service.utils.PersonalRequestFieldConverter;

import java.util.function.Function;

public enum FieldType {
    NUMBER(PersonalRequestFieldConverter::asLong),
    TEXT(PersonalRequestFieldConverter::asString),
    LABEL(PersonalRequestFieldConverter::asString),
    DECIMAL(PersonalRequestFieldConverter::asDecimal),
    DATE(PersonalRequestFieldConverter::asDate),
    LIST(PersonalRequestFieldConverter::asString);

    private final Function<String,?> conversionFunction;

    FieldType(Function<String, ?> conversionFunction) {
        this.conversionFunction = conversionFunction;
    }

    public Function<String, ?> conversionFunction() {
        return conversionFunction;
    }
}
