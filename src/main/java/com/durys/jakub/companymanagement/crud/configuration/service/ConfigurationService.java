package com.durys.jakub.companymanagement.crud.configuration.service;

import com.durys.jakub.companymanagement.crud.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.crud.configuration.model.util.ConfigurationGroup;
import com.durys.jakub.companymanagement.crud.configuration.model.enums.group.ConfigurationGroupName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfigurationService {


    public List<? extends CmConfigurationType<?>> findAllByConfigurationGroupName(ConfigurationGroupName configurationGroupName) {
        return ConfigurationGroup.ofName(configurationGroupName).getConfigTypes();
    }
}
