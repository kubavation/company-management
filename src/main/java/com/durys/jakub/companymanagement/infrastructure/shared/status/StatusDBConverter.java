package com.durys.jakub.companymanagement.infrastructure.shared.status;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

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
