package com.durys.jakub.companymanagement.request.personal_request.repository;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestType;
import com.durys.jakub.companymanagement.shared.repository.CmRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRequestTypeRepository extends CmRepository<PersonalRequestType, Long> {
}
