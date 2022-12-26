package com.durys.jakub.companymanagement.crud.personal_request.repository;

import com.durys.jakub.companymanagement.crud.personal_request.model.entity.general.PersonalRequest;
import com.durys.jakub.companymanagement.shared.repository.CmRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRequestRepository extends CmRepository<PersonalRequest, Long> {

    List<PersonalRequest> findAllByEmployeeId(Long employeeId);
}
