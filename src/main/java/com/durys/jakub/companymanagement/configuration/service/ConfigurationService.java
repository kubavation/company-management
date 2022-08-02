package com.durys.jakub.companymanagement.configuration.service;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.configuration.model.enums.group.ConfigurationGroupName;
import com.durys.jakub.companymanagement.configuration.model.util.ConfigurationGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigurationService {


    public List<? extends CmConfigurationType<?>> findAllByConfigurationGroupName(ConfigurationGroupName configurationGroupName) {
        return configurationGroup.getConfigTypes();
    }
}
