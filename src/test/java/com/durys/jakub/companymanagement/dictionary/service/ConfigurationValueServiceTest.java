package com.durys.jakub.companymanagement.dictionary.service;

import com.durys.jakub.companymanagement.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.configuration.model.enums.ConfigurationGroup;
import com.durys.jakub.companymanagement.configuration.repository.ConfigurationValueRepository;
import com.durys.jakub.companymanagement.configuration.service.ConfigurationValueService;
import com.durys.jakub.companymanagement.shared.enums.Status;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ConfigurationValueServiceTest {

    @InjectMocks
    private ConfigurationValueService configurationValueService;

    @Mock
    private ConfigurationValueRepository configurationValueRepository;

    @Test
    public void findByConfigurationType_shouldReturnConfigValue() {
        ConfigurationValue val1
                = new ConfigurationValue(1L, ConfigurationGroup.MENU_OPTION, ConfigurationType.TEST, "value", Status.ACTIVE);

        when(configurationValueRepository.findByConfigurationType(ConfigurationType.TEST))
                .thenReturn(Optional.of(val1));

        assertEquals(configurationValueService.findByConfigurationType(ConfigurationType.TEST).getId(), val1.getId());
    }

    @Test
    public void findByConfigurationType_shouldThrowException() {
        ConfigurationValue val1
                = new ConfigurationValue(1L, ConfigurationGroup.GENERAL, null, "value", Status.ACTIVE);

        when(configurationValueRepository.findByConfigurationType(ConfigurationType.TEST))
                .thenThrow(EntityNotFoundException.class);

        assertThrows(EntityNotFoundException.class,
                () -> configurationValueService.findByConfigurationType(ConfigurationType.TEST));
    }

}