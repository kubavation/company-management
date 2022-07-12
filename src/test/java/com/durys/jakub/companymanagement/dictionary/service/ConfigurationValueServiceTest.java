package com.durys.jakub.companymanagement.dictionary.service;

import com.durys.jakub.companymanagement.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.configuration.model.enums.ConfigurationGroup;
import com.durys.jakub.companymanagement.configuration.model.enums.MenuOption;
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
                = new ConfigurationValue(1L, ConfigurationGroup.MENU_OPTION, MenuOption.ADMINISTRATION.name(), "value", Status.ACTIVE);

        when(configurationValueRepository.findByConfigurationType(MenuOption.ADMINISTRATION.name()))
                .thenReturn(Optional.of(val1));

        assertEquals(configurationValueService.findByConfigurationType(MenuOption.ADMINISTRATION.name()).getId(), val1.getId());
    }

    @Test
    public void findByConfigurationType_shouldThrowException() {
        ConfigurationValue val1
                = new ConfigurationValue(1L, ConfigurationGroup.GENERAL, null, "value", Status.ACTIVE);

        when(configurationValueRepository.findByConfigurationType("TEST"))
                .thenThrow(EntityNotFoundException.class);

        assertThrows(EntityNotFoundException.class,
                () -> configurationValueService.findByConfigurationType("TEST"));
    }

}