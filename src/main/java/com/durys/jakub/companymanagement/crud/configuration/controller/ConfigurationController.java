package com.durys.jakub.companymanagement.crud.configuration.controller;

import com.durys.jakub.companymanagement.crud.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.crud.configuration.model.dto.ConfigOption;
import com.durys.jakub.companymanagement.crud.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.crud.configuration.model.enums.group.ConfigurationGroupName;
import com.durys.jakub.companymanagement.crud.configuration.service.ConfigurationService;
import com.durys.jakub.companymanagement.crud.configuration.service.ConfigurationValueService;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/configuration")
@CrossOrigin(origins = "http://localhost:4200")
public class ConfigurationController {

    private final ConfigurationValueService configurationValueService;
    private final ConfigurationService configurationService;

    @GetMapping("/type/{configurationType}")
    public ConfigOption findByConfigurationType(@PathVariable String configurationType) {
        return configurationValueService.findByConfigurationType(configurationType)
                .map(val -> ConfigOption.of(val.getValue(), configurationType))
                .orElseThrow(EntityNotFoundException.of(ConfigurationValue.class, configurationType));
    }

    @GetMapping("/group/{configurationGroupName}")
    public ResponseEntity<?> findAllByConfigurationGroup(@PathVariable ConfigurationGroupName configurationGroupName) {

        List<? extends CmConfigurationType<?>> configurationItems =
                configurationService.findAllByConfigurationGroupName(configurationGroupName);

        configurationItems.stream().forEach(c -> System.out.println(c));

        List<ConfigOption> result = configurationItems.stream()
                .filter(CmConfigurationType::isEnabled)
                .map(configType -> ConfigOption.of(configType, configurationGroupName,
                        configurationValueService.getValueOrDefault(configurationGroupName, configType)))
                .toList();

        result.stream().forEach(c -> System.out.println(c));

        return ResponseEntity.ok(result);
    }

}
