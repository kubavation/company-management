package com.durys.jakub.companymanagement.crud.personal_request.repository;

import com.durys.jakub.companymanagement.crud.personal_request.model.entity.dict.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.shared.repository.CmRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRequestFieldTypeRepository extends CmRepository<PersonalRequestFieldType, Long> {

    List<PersonalRequestFieldType> findAllByRequestTypeId(Long requestTypeId);
}
