package com.durys.jakub.companymanagement.configuration.service;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.configuration.model.enums.ConfigurationGroup;
import com.durys.jakub.companymanagement.configuration.repository.ConfigurationValueRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
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
        return configurationValueRepository.findByConfigurationGroupAndConfigurationType(group, type);
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
