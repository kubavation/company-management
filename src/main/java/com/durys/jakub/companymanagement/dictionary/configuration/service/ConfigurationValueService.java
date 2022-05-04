package com.durys.jakub.companymanagement.dictionary.configuration.service;

import com.durys.jakub.companymanagement.dictionary.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.dictionary.configuration.model.enums.ConfigurationGroup;
import com.durys.jakub.companymanagement.dictionary.configuration.model.enums.ConfigurationType;
import com.durys.jakub.companymanagement.dictionary.configuration.repository.ConfigurationValueRepository;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigurationValueService {

    private final ConfigurationValueRepository configurationValueRepository;


    public ConfigurationValue findByConfigurationType(ConfigurationType configurationType) {
        return configurationValueRepository.findByConfigurationType(configurationType)
                .orElseThrow(() -> new EntityNotFoundException(ConfigurationValue.class, String.valueOf(configurationType)));
    }

    public List<ConfigurationValue> findAllByConfigurationGroup(ConfigurationGroup configurationGroup) {
        return configurationValueRepository.findAllByConfigurationGroup(configurationGroup);
    }
}
