package com.durys.jakub.companymanagement.request.personal_request.repository;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequest;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRequestRepository extends JpaRepository<PersonalRequest, Long> {
}
