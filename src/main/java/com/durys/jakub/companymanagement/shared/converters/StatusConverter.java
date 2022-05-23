package com.durys.jakub.companymanagement.shared.converters;

import com.durys.jakub.companymanagement.shared.enums.Status;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.getShortcut();
    }

    @Override
    public Status convertToEntityAttribute(String shortcut) {
       return Status.of(shortcut);
    }
}
