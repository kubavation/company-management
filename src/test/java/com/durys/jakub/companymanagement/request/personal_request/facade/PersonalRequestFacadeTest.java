package com.durys.jakub.companymanagement.request.personal_request.facade;

import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import com.durys.jakub.companymanagement.request.personal_request.converter.general.PersonalRequestMapper;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.creational.CreatePersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.creational.CreatePersonalRequestField;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.service.dict.PersonalRequestFieldTypeService;
import com.durys.jakub.companymanagement.request.personal_request.service.dict.PersonalRequestTypeService;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    private PersonalRequestFieldTypeService personalRequestFieldTypeService;
    @Mock
    private PersonalRequestMapper personalRequestMapper;

    private CreatePersonalRequest request;

    @BeforeEach
    public void init() {
        this.request = CreatePersonalRequest.builder()
                .employeeId(1L)
                .requestTypeId(1L)
                .fields(List.of(
                        new CreatePersonalRequestField("name", 1L),
                        new CreatePersonalRequestField("type", 2L)))
                .build();
    }

    @Test
    public void create_shouldThrowExceptionWhenEmployeeNotFound() {

        Mockito.when(personalRequestMapper.toEntity(request)).thenReturn(new PersonalRequest());
        Mockito.when(employeeService.findById(1L)).thenThrow(EntityNotFoundException.class);

        assertThrows(EntityNotFoundException.class, () -> personalRequestFacade.create(request));
    }

    @Test
    public void create_shouldThrowExceptionWhenRequestTypeNotFound() {

        Mockito.when(personalRequestMapper.toEntity(request)).thenReturn(new PersonalRequest());
        Mockito.when(personalRequestTypeService.findById(1L)).thenThrow(EntityNotFoundException.class);

        assertThrows(EntityNotFoundException.class, () -> personalRequestFacade.create(request));
    }

    @Test
    public void create_shouldThrowExceptionWhenRequestFieldSizeNotEqualsRequestTypeFieldSize() {

        Mockito.when(personalRequestMapper.toEntity(request)).thenReturn(new PersonalRequest());
        Mockito.when(personalRequestFieldTypeService.findAllByPersonalRequestTypeId(1L))
                .thenReturn(
                        List.of(PersonalRequestFieldType.builder().build())
                );

        assertThrows(RuntimeException.class, () -> personalRequestFacade.create(request));
    }

}