package com.durys.jakub.companymanagement.configuration.controller;

import com.durys.jakub.companymanagement.configuration.model.CmConfigurationType;
import com.durys.jakub.companymanagement.configuration.model.dto.ConfigOption;
import com.durys.jakub.companymanagement.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.configuration.model.enums.ConfigurationGroup;
import com.durys.jakub.companymanagement.configuration.service.ConfigurationService;
import com.durys.jakub.companymanagement.configuration.service.ConfigurationValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/configuration")
@CrossOrigin(origins = "http://localhost:4200")
public class ConfigurationController {

    private final ConfigurationValueService configurationValueService;
    private final ConfigurationService configurationService;

    @GetMapping("/type/{configurationType}")
    public ResponseEntity<ConfigurationValue> findByConfigurationType(@PathVariable String configurationType) {
        //return ResponseEntity.ok(configurationValueService.findByConfigurationType(configurationType));
        return null;
    }

    @GetMapping("/group/{configurationGroup}")
    public ResponseEntity<?> findAllByConfigurationGroup(@PathVariable ConfigurationGroup configurationGroup) {

        List<? extends CmConfigurationType<?>> configurationItems =
                configurationService.findAllByConfigurationGroup(configurationGroup);

        List<ConfigOption> result = configurationItems.stream()
                .map(configType ->
                        ConfigOption.of(configType, configurationGroup, getValueOrDefault(configurationGroup, configType)))
                .toList();

        return ResponseEntity.ok(result);
    }

    private String getValueOrDefault(ConfigurationGroup configurationGroup, CmConfigurationType<?> type) {
        return configurationValueService
                .findByConfigurationGroupAndType(configurationGroup, type.name())
                .map(ConfigurationValue::getValue)
                .orElse(String.valueOf(type.defaultValue()));
    }
}
