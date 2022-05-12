package com.durys.jakub.companymanagement.request.personal_request.facade;

import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import com.durys.jakub.companymanagement.request.personal_request.converter.general.PersonalRequestMapper;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.creational.CreatePersonalRequest;
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

        PersonalRequest entity = personalRequestMapper.toEntity(personalRequest);
        entity.setStatus("A");

        //finding employee
        entity.setEmployee(employeeService.findById(personalRequest.getEmployeeId()));
        //finding requestType
        PersonalRequestType requestType = personalRequestTypeService
                .findById(personalRequest.getRequestTypeId());

        entity.setRequestType(requestType);

        List<PersonalRequestFieldType> fieldTypes = personalRequestFieldTypeService
                .findAllByPersonalRequestTypeId(requestType.getId());

        if(fieldTypes.size() != personalRequest.getFields().size()) {
            throw new RuntimeException();
        }

        List<PersonalRequestField> fields = personalRequest.getFields()
                .stream()
                .map(field -> {
                    PersonalRequestFieldType fieldType = personalRequestFieldTypeService
                            .findById(field.getFieldTypeId());
                    return PersonalRequestField.builder()
                            .requestFieldType(fieldType)
                            .status("A")
                            .personalRequest(entity)
                            .value(field.getValue()).build();
                }).toList();


        entity.setFields(fields);

        PersonalRequest result = personalRequestService.create(entity);

        return result;
    }
}
