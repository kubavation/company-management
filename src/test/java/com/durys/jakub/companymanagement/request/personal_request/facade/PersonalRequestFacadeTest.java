package com.durys.jakub.companymanagement.request.personal_request.facade;

import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import com.durys.jakub.companymanagement.request.personal_request.converter.general.PersonalRequestMapper;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.creational.CreatePersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.service.dict.PersonalRequestTypeService;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonalRequestFacadeTest {

    @InjectMocks
    private PersonalRequestFacade personalRequestFacade;

    @Mock
    private EmployeeService employeeService;
    @Mock
    private PersonalRequestTypeService personalRequestTypeService;
    @Mock
    private PersonalRequestMapper personalRequestMapper;

    @Test
    public void create_shouldThrowExceptionWhenEmployeeNotFound() {
        CreatePersonalRequest request = CreatePersonalRequest.builder()
                .employeeId(1L).build();

        Mockito.when(personalRequestMapper.toEntity(request)).thenReturn(new PersonalRequest());
        Mockito.when(employeeService.findById(1L)).thenThrow(EntityNotFoundException.class);

        assertThrows(EntityNotFoundException.class, () -> personalRequestFacade.create(request));
    }

    @Test
    public void create_shouldThrowExceptionWhenRequestTypeNotFound() {
        CreatePersonalRequest request = CreatePersonalRequest.builder()
                .requestTypeId(1L).build();

        Mockito.when(personalRequestMapper.toEntity(request)).thenReturn(new PersonalRequest());
        Mockito.when(personalRequestTypeService.findById(1L)).thenThrow(EntityNotFoundException.class);

        assertThrows(EntityNotFoundException.class, () -> personalRequestFacade.create(request));
    }

}