package com.durys.jakub.companymanagement.request.personal_request.repository;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.dict.PersonalRequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRequestTypeRepository extends JpaRepository<PersonalRequestType, Long> {
}
