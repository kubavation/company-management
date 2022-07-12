package com.durys.jakub.companymanagement.configuration.model.enums;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Set;
import static java.util.Set.of;

@AllArgsConstructor
@Getter
public enum ConfigurationGroup {
    GENERAL("GENERAL", of()),
    MENU_OPTION("MENU_OPTION", of(MenuOption.class));

    private final String description;
    private final Set<Class<? extends CmConfigurationType<?>>> classes;
}
