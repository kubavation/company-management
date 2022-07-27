package com.durys.jakub.companymanagement.configuration.model.enums;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
@AllArgsConstructor
public enum MenuOption implements CmConfigurationType<Boolean> {
    ADMINISTRATION("Administration", "/administration", true),
    PERSONAL_DATA("Personal data", "/personal-data", true),
    PERSONAL_REQUEST("Personal requests", "/personal-request", false);

    private final String desc;
    private final String url;
    private final Boolean defaultValue;

    @Override
    public Boolean defaultValue() {
        return this.defaultValue;
    }

    @Override
    public String desc() {
        return this.desc;
    }

}
