package com.durys.jakub.companymanagement.configuration.model.util;

import com.durys.jakub.companymanagement.configuration.exception.ConfigurationGroupNotExistsException;
import com.durys.jakub.companymanagement.configuration.exception.ConfigurationTypeAlreadyExistsException;
import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.configuration.model.enums.group.ConfigurationGroupName;
import com.durys.jakub.companymanagement.configuration.model.enums.type.MenuOption;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.*;

import static java.util.Set.of;

//@AllArgsConstructor
//@Getter
//public enum ConfigurationGroup {
//    GENERAL("GENERAL", of()),
//    MENU_OPTION("MENU_OPTION", of(MenuOption.class));
//
//
//    private final String description;
//    private final Set<Class<? extends CmConfigurationType<?>>> classes;
//}

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ConfigurationGroup {

    private static HashMap<String, ConfigurationGroupName> CONFIG_TYPE_MAP = new HashMap<>();


    public static final ConfigurationGroup GENERAL
            = of(ConfigurationGroupName.GENERAL, "GENERAL", Set.of());
    public static final ConfigurationGroup MENU_OPTION
            = of(ConfigurationGroupName.MENU_OPTION, "MENU_OPTION", Set.of(MenuOption.class));

    @NonNull private final ConfigurationGroupName configurationGroupName;
    @NonNull private final String description;
    @NonNull private final List<? extends CmConfigurationType<?>> configTypes;



    private static ConfigurationGroup of(ConfigurationGroupName name, String desc,
                                         Set<Class<? extends CmConfigurationType<?>>> classes) {
        List<? extends CmConfigurationType<?>> configTypes = configTypeList(classes);
        addConfigTypes(configTypes, name);
        return new ConfigurationGroup(name, desc, configTypes);
    }

    private static void addConfigTypes(List<? extends CmConfigurationType<?>> types, ConfigurationGroupName groupName) {
        types.forEach(t -> {
            if (CONFIG_TYPE_MAP.containsKey(t.name())) {
                throw new ConfigurationTypeAlreadyExistsException(t.name());
            }
            CONFIG_TYPE_MAP.put(t.name(), groupName);
        });
    }

    private static List<? extends CmConfigurationType<?>> configTypeList(Set<Class<? extends CmConfigurationType<?>>> classes) {
        return classes.stream()
                .map(Class::getEnumConstants)
                .flatMap(Arrays::stream).toList();
    }

    public static ConfigurationGroupName getConfigurationGroupByType(CmConfigurationType<?> configurationType) {
        return CONFIG_TYPE_MAP.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(configurationType.name()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(ConfigurationGroupNotExistsException::new);
    }

}
