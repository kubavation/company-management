package com.durys.jakub.companymanagement.configuration.service;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.configuration.model.enums.ConfigurationGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConfigurationService {


    public List<? extends CmConfigurationType<?>> findAllByConfigurationGroup(ConfigurationGroup configurationGroup) {
        return configurationGroup.getClasses()
                .stream()
                .flatMap(c -> Arrays.stream(c.getEnumConstants()))
                .toList();
    }
}
