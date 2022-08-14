package com.durys.jakub.companymanagement.request.leave_request.model.converter;

import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LeaveRequestTypeConverter implements AttributeConverter<LeaveRequestType, String> {

    @Override
    public String convertToDatabaseColumn(LeaveRequestType leaveRequestType) {
        return leaveRequestType.getShortcut();
    }

    @Override
    public LeaveRequestType convertToEntityAttribute(String shortcut) {
        return LeaveRequestType.ofShortcut(shortcut);
    }
}
