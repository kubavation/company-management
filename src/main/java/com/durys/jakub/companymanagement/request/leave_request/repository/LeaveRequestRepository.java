package com.durys.jakub.companymanagement.request.leave_request.repository;

import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long>, JpaSpecificationExecutor<LeaveRequest> {

    @Query("FROM LeaveRequest l WHERE l.employee.id = :employeeId and l.status = 'A' order by l.dateFrom desc")
    List<LeaveRequest> findAllByEmployeeId(Long employeeId);
    @Query("FROM LeaveRequest l WHERE l.employee.id = :employeeId and l.status = 'A' and l.type = :type" +
            " order by l.dateFrom desc")
    List<LeaveRequest> findAllByEmployeeIdAndType(Long employeeId, LeaveRequestType type);
}
