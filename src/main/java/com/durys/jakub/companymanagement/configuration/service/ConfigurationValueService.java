package com.durys.jakub.companymanagement.configuration.service;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.configuration.model.util.ConfigurationGroup;
import com.durys.jakub.companymanagement.configuration.repository.ConfigurationValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfigurationValueService {

    private final ConfigurationValueRepository configurationValueRepository;

    public Optional<ConfigurationValue> findByConfigurationType(String configurationType) {
        return configurationValueRepository.findByConfigurationType(configurationType);
    }

    public Optional<ConfigurationValue> findByConfigurationGroupAndType(ConfigurationGroup group, String type) {
        System.out.println(group);
        System.out.println(type);
        return configurationValueRepository.findByConfigurationGroupAndConfigurationType(group.getConfigurationGroupName(), type);
    }

    public List<ConfigurationValue> findAllByConfigurationGroup(ConfigurationGroup configurationGroup) {
        return configurationValueRepository.findAllByConfigurationGroup(configurationGroup);
    }

    public String getValueOrDefault(ConfigurationGroup configurationGroup, CmConfigurationType<?> type) {
        return findByConfigurationGroupAndType(configurationGroup, type.name())
                .map(ConfigurationValue::getValue)
                .orElse(String.valueOf(type.defaultValue()));
    }
}
