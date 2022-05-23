package com.durys.jakub.companymanagement.request.personal_request.repository;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.general.PersonalRequest;
import com.durys.jakub.companymanagement.shared.repository.SafeDeleteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRequestRepository extends SafeDeleteRepository<PersonalRequest, Long> {

    List<PersonalRequest> findAllByEmployeeId(Long employeeId);
}
