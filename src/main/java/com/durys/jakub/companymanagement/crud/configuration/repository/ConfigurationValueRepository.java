package com.durys.jakub.companymanagement.crud.configuration.repository;

import com.durys.jakub.companymanagement.crud.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.crud.configuration.model.enums.group.ConfigurationGroupName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigurationValueRepository extends JpaRepository<ConfigurationValue, Long> {

    Optional<ConfigurationValue> findByConfigurationType(String type);

    List<ConfigurationValue> findAllByConfigurationGroup(ConfigurationGroupName group);

    Optional<ConfigurationValue> findByConfigurationGroupAndConfigurationType(ConfigurationGroupName groupName, String type);
}
