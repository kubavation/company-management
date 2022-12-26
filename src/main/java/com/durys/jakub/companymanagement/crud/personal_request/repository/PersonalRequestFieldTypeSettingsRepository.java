package com.durys.jakub.companymanagement.crud.personal_request.repository;

import com.durys.jakub.companymanagement.crud.personal_request.model.entity.dict.PersonalRequestFieldTypeSettings;
import com.durys.jakub.companymanagement.shared.repository.CmRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalRequestFieldTypeSettingsRepository extends CmRepository<PersonalRequestFieldTypeSettings, Long> {

   List<PersonalRequestFieldTypeSettings> findAllByFieldTypeId(Long fieldTypeId);
}
