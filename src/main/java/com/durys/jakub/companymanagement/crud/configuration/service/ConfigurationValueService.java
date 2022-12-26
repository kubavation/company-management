package com.durys.jakub.companymanagement.crud.configuration.service;

import com.durys.jakub.companymanagement.crud.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.crud.configuration.repository.ConfigurationValueRepository;
import com.durys.jakub.companymanagement.crud.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.crud.configuration.model.enums.group.ConfigurationGroupName;
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

    public Optional<ConfigurationValue> findByConfigurationGroupAndType(ConfigurationGroupName groupName, String type) {
        return configurationValueRepository.findByConfigurationGroupAndConfigurationType(groupName, type);
    }

    public List<ConfigurationValue> findAllByConfigurationGroup(ConfigurationGroupName configurationGroupName) {
        return configurationValueRepository.findAllByConfigurationGroup(configurationGroupName);
    }

    public String getValueOrDefault(ConfigurationGroupName configurationGroupName, CmConfigurationType<?> type) {
        return findByConfigurationGroupAndType(configurationGroupName, type.name())
                .map(ConfigurationValue::getValue)
                .orElse(String.valueOf(type.defaultValue()));
    }
}
