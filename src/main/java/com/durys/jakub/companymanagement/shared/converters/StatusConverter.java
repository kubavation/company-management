package com.durys.jakub.companymanagement.shared.converters;

import com.durys.jakub.companymanagement.shared.enums.CmStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StatusConverter implements AttributeConverter<CmStatus, String> {

    @Override
    public String convertToDatabaseColumn(CmStatus cmStatus) {
        return cmStatus.getShortcut();
    }

    @Override
    public CmStatus convertToEntityAttribute(String shortcut) {
       return CmStatus.of(shortcut);
    }
}
