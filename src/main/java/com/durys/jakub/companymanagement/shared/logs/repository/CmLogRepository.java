package com.durys.jakub.companymanagement.shared.logs.repository;

import com.durys.jakub.companymanagement.shared.logs.model.CmLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CmLogRepository extends JpaRepository<CmLog, Long> {
}
