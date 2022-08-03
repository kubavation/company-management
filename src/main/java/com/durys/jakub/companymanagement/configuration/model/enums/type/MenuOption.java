package com.durys.jakub.companymanagement.configuration.model.enums.type;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum MenuOption implements CmConfigurationType<String> {
    ADMINISTRATION("Administration", "/administration", null, true),
    PERSONAL_DATA("Personal data", "/personal-data", null, true),
    PERSONAL_REQUEST("Personal requests", "/personal-request", null, false);

    private final String desc;
    private final String url;
    private final String defaultValue;
    private final Boolean enabled;

    @Override
    public String defaultValue() {
        return getValue();
    }

    @Override
    public String desc() {
        return desc;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getValue() {
        return url;
    }
}
