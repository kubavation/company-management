package com.durys.jakub.companymanagement.request.personal_request.facade;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import com.durys.jakub.companymanagement.request.personal_request.converter.general.PersonalRequestMapper;
import com.durys.jakub.companymanagement.request.personal_request.exception.RequestFieldIncompatibleSizeException;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.creational.CreatePersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.creational.CreatePersonalRequestField;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequestField;
import com.durys.jakub.companymanagement.request.personal_request.service.dict.PersonalRequestFieldTypeService;
import com.durys.jakub.companymanagement.request.personal_request.service.dict.PersonalRequestTypeService;
import com.durys.jakub.companymanagement.request.personal_request.service.general.PersonalRequestService;
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
    @Mock
    private PersonalRequestService personalRequestService;

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
        Mockito.when(personalRequestTypeService.findById(1L)).thenReturn(new PersonalRequestType());
        Mockito.when(employeeService.findById(1L)).thenReturn(new Employee());
        Mockito.when(personalRequestFieldTypeService.findAllByPersonalRequestTypeId(1L))
                .thenReturn(
                        List.of(PersonalRequestFieldType.builder().build())
                );

        Exception exception = assertThrows(RequestFieldIncompatibleSizeException.class, () -> personalRequestFacade.create(request));
        assertEquals(exception.getMessage(), RequestFieldIncompatibleSizeException.MSG);
    }

    @Test
    public void create_shouldThrowExceptionWhenFieldTypeNotFound() {
        Mockito.when(personalRequestMapper.toEntity(request)).thenReturn(new PersonalRequest());
        Mockito.when(personalRequestTypeService.findById(1L)).thenReturn(PersonalRequestType.builder().id(1L).build());
        Mockito.when(employeeService.findById(1L)).thenReturn(new Employee());
        Mockito.when(personalRequestFieldTypeService.findById(2L)).thenThrow(EntityNotFoundException.class);

        Mockito.when(personalRequestFieldTypeService.findAllByPersonalRequestTypeId(1L))
                .thenReturn(
                        List.of(
                            PersonalRequestFieldType.builder().build(),
                            PersonalRequestFieldType.builder().build()
                        )
                );

        assertThrows(EntityNotFoundException.class, () -> personalRequestFacade.create(request));

    }

    @Test
    public void create_shouldSaveSuccessfuly() {

        Mockito.when(personalRequestMapper.toEntity(request)).thenReturn(new PersonalRequest());
        Mockito.when(personalRequestTypeService.findById(1L)).thenReturn(PersonalRequestType.builder().id(1L).build());
        Mockito.when(employeeService.findById(1L)).thenReturn(new Employee());
        Mockito.when(personalRequestFieldTypeService.findById(Mockito.anyLong())).
                thenReturn(new PersonalRequestFieldType());

        List<PersonalRequestFieldType> fieldResult = List.of(
                PersonalRequestFieldType.builder().build(),
                PersonalRequestFieldType.builder().build());

        Mockito.when(personalRequestFieldTypeService.findAllByPersonalRequestTypeId(1L)).thenReturn(fieldResult);

        Mockito.when(personalRequestService.create(Mockito.any(PersonalRequest.class)))
                .thenReturn(PersonalRequest.builder().id(1L)
                        .fields(List.of(
                            PersonalRequestField.builder().build(),
                            PersonalRequestField.builder().build()
                        ))
                .build());

        PersonalRequest result = personalRequestFacade.create(request);
        assertEquals(result.getFields().size(), fieldResult.size());
        assertEquals(result.getId(), 1L);
    }

}