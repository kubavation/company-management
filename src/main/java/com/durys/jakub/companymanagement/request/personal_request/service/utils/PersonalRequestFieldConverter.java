package com.durys.jakub.companymanagement.request.personal_request.service.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonalRequestFieldConverter {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDateTime asDate(String val) {
        return LocalDateTime.from(dateTimeFormatter.parse(val));
    }

    public static Long asLong(String val) {
        return Long.valueOf(val);
    }

    public static BigDecimal asDecimal(String val) {
        return new BigDecimal(val);
    }

    public static String asString(String val) {
        return val;
    }


}
