package com.durys.jakub.companymanagement.shared.logs.repository;

import com.durys.jakub.companymanagement.shared.logs.model.CmLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CmLogRepository extends JpaRepository<CmLog, Long> {

    @Query(value =
            "select cc.* from (select * from CM_LOG c " +
            "where c.primary_key = :pk and c.table_name = :tableName order by c.timestamp desc) cc limit 1", nativeQuery = true)
    Optional<CmLog> findLastObjectByIdAndTableName(Long pk, String tableName);
}
