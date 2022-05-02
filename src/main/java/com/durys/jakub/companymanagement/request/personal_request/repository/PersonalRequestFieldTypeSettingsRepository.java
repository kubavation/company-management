package com.durys.jakub.companymanagement.request.personal_request.repository;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldType;
import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequestFieldTypeSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRequestFieldTypeSettingsRepository extends JpaRepository<PersonalRequestFieldTypeSettings, Long> {

   List<PersonalRequestFieldTypeSettings> findAllByFieldTypeId(Long fieldTypeId);
}
