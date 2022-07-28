package com.durys.jakub.companymanagement.configuration.model.enums.type;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

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

    @Override
    public String declaringClassName() {
        return this.getDeclaringClass().getSimpleName();
    }

}
