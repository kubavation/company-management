package com.durys.jakub.companymanagement.request.personal_request.facade;

import com.durys.jakub.companymanagement.employee.service.EmployeeService;
import com.durys.jakub.companymanagement.request.personal_request.converter.general.PersonalRequestMapper;
import com.durys.jakub.companymanagement.request.personal_request.model.dto.general.PersonalRequestDTO;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequestField;
import com.durys.jakub.companymanagement.request.personal_request.service.dict.PersonalRequestTypeService;
import com.durys.jakub.companymanagement.request.personal_request.service.general.PersonalRequestFieldService;
import com.durys.jakub.companymanagement.request.personal_request.service.general.PersonalRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonalRequestFacade {

    private final PersonalRequestService personalRequestService;
    private final PersonalRequestFieldService personalRequestFieldService;
    private final PersonalRequestTypeService personalRequestTypeService;
    private final EmployeeService employeeService;
    private final PersonalRequestMapper personalRequestMapper;

    @Transactional
    public PersonalRequest create(PersonalRequestDTO requestDTO) {
        System.out.println(requestDTO);
        PersonalRequest entity = personalRequestMapper.toEntity(requestDTO);
        System.out.println("ENTITY---");
        System.out.println(entity);

        //finding employee
        entity.setEmployee(employeeService.findById(requestDTO.getEmployeeId()));
        //finding requestType
        entity.setRequestType(personalRequestTypeService.findById(requestDTO.getRequestTypeId()));

        //fields
        requestDTO.getFields()
                .stream()
                .forEach(s -> System.out.println(s));


        //System.out.println(entity);

        return null;
    }
}
