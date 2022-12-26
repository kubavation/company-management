package com.durys.jakub.companymanagement.dictionary.service;

import com.durys.jakub.companymanagement.crud.configuration.repository.ConfigurationValueRepository;
import com.durys.jakub.companymanagement.crud.configuration.service.ConfigurationValueService;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigurationValueServiceTest {

    @InjectMocks
    private ConfigurationValueService configurationValueService;

    @Mock
    private ConfigurationValueRepository configurationValueRepository;



//    @Test
//    public void findByConfigurationType_shouldReturnConfigValue() {
//        ConfigurationValue val1
//                = new ConfigurationValue(1L, ConfigurationGroup.MENU_OPTION, MenuOption.ADMINISTRATION.name(), "value", Status.ACTIVE);
//
//        when(configurationValueRepository.findByConfigurationType(MenuOption.ADMINISTRATION.name()))
//                .thenReturn(Optional.of(val1));
//
//        assertEquals(configurationValueService.findByConfigurationType(MenuOption.ADMINISTRATION.name()).getId(), val1.getId());
//    }
//
//    @Test
//    public void findByConfigurationType_shouldThrowException() {
//        ConfigurationValue val1
//                = new ConfigurationValue(1L, ConfigurationGroup.GENERAL, null, "value", Status.ACTIVE);
//
//        when(configurationValueRepository.findByConfigurationType("TEST"))
//                .thenThrow(EntityNotFoundException.class);
//
//        assertThrows(EntityNotFoundException.class,
//                () -> configurationValueService.findByConfigurationType("TEST"));
//    }

}