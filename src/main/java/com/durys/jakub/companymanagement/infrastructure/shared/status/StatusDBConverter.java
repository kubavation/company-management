package com.durys.jakub.companymanagement.infrastructure.shared.status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StatusDBConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.shortcut();
    }

    @Override
    public Status convertToEntityAttribute(String shortcut) {
        return Status.valueOf(shortcut);
    }
}
