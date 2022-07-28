package com.durys.jakub.companymanagement.configuration.repository;

import com.durys.jakub.companymanagement.configuration.model.entity.ConfigurationValue;
import com.durys.jakub.companymanagement.configuration.model.util.ConfigurationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfigurationValueRepository extends JpaRepository<ConfigurationValue, Long> {

    Optional<ConfigurationValue> findByConfigurationType(String type);

    List<ConfigurationValue> findAllByConfigurationGroup(ConfigurationGroup group);

    Optional<ConfigurationValue> findByConfigurationGroupAndConfigurationType(ConfigurationGroup group, String type);
}
