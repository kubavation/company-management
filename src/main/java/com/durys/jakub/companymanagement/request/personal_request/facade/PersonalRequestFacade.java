package com.durys.jakub.companymanagement.request.personal_request.facade;

import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import com.durys.jakub.companymanagement.request.personal_request.converter.general.PersonalRequestMapper;
import com.durys.jakub.companymanagement.request.personal_request.exception.RequestFieldIncompatibleSizeException;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.creational.CreatePersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.creational.CreatePersonalRequestField;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.general.PersonalRequestDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequestField;
import com.durys.jakub.companymanagement.request.personal_request.service.dict.PersonalRequestFieldTypeService;
import com.durys.jakub.companymanagement.request.personal_request.service.dict.PersonalRequestTypeService;
import com.durys.jakub.companymanagement.request.personal_request.service.general.PersonalRequestFieldService;
import com.durys.jakub.companymanagement.request.personal_request.service.general.PersonalRequestService;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PersonalRequestFacade {

    private final PersonalRequestService personalRequestService;
    private final PersonalRequestFieldService personalRequestFieldService;
    private final PersonalRequestTypeService personalRequestTypeService;
    private final PersonalRequestFieldTypeService personalRequestFieldTypeService;
    private final EmployeeService employeeService;
    private final PersonalRequestMapper personalRequestMapper;

    @Transactional
    public PersonalRequest create(CreatePersonalRequest personalRequest) {

        PersonalRequest entity = preparePersonalRequestEntity(personalRequest);

        List<PersonalRequestFieldType> fieldTypes = personalRequestFieldTypeService
                .findAllByPersonalRequestTypeId(entity.getRequestType().getId());

        validatePersonalRequestFieldSize(fieldTypes, personalRequest.getFields());

        entity.setFields(preparePersonalRequestFields(entity, personalRequest.getFields()));

        return personalRequestService.create(entity);
    }

    private void validatePersonalRequestFieldSize(List<PersonalRequestFieldType> fieldTypes,
                                                  List<CreatePersonalRequestField> dtoFields) {
        if (fieldTypes.size() != dtoFields.size()) {
            throw new RequestFieldIncompatibleSizeException();
        }
    }

    private PersonalRequest preparePersonalRequestEntity(CreatePersonalRequest dto) {
        PersonalRequest entity = personalRequestMapper.toEntity(dto);
        entity.setEmployee(employeeService.findById(dto.getEmployeeId()));
        entity.setRequestType(personalRequestTypeService.findById(dto.getRequestTypeId()));
        entity.setStatus("A");
        return entity;
    }

    private List<PersonalRequestField> preparePersonalRequestFields(PersonalRequest entity,
                                                    List<CreatePersonalRequestField> fields) {
        return fields.stream()
                .map(field ->
                        PersonalRequestField.builder()
                                .requestFieldType(personalRequestFieldTypeService.findById(field.getFieldTypeId()))
                                .status("A")
                                .personalRequest(entity)
                                .value(field.getValue()).build())
                .toList();
    }
}
