package com.durys.jakub.companymanagement.configuration.model.enums;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
@AllArgsConstructor
public enum MenuOption implements CmConfigurationType<Boolean> {
    ADMINISTRATION("ADMINISTRATION", "/administration", true);

    private final String name;
    private final String url;
    private final Boolean defaultValue;

    @Override
    public Boolean defaultValue() {
        return this.defaultValue;
    }

}
