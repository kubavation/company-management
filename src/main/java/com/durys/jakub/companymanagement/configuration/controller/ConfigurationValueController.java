package com.durys.jakub.companymanagement.configuration.controller;

import com.durys.jakub.companymanagement.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.configuration.model.enums.ConfigurationGroup;
import com.durys.jakub.companymanagement.configuration.service.ConfigurationValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/configuration")
public class ConfigurationValueController {

    private final ConfigurationValueService configurationValueService;

    @GetMapping("/type/{configurationType}")
    public ResponseEntity<ConfigurationValue> findByConfigurationType(@PathVariable String configurationType) {
        return ResponseEntity.ok(configurationValueService.findByConfigurationType(configurationType));
    }

    @GetMapping("/group/{configurationGroup}")
    public ResponseEntity<?> findAllByConfigurationGroup(@PathVariable ConfigurationGroup configurationGroup) {
        return ResponseEntity.ok(configurationValueService.findAllByConfigurationGroup(configurationGroup));
    }
}
