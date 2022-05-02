package com.durys.jakub.companymanagement.request.personal_request.repository;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRequestFieldTypeRepository extends JpaRepository<PersonalRequestFieldType, Long> {

    List<PersonalRequestFieldType> findAllByRequestTypeId(Long requestTypeId);
}
