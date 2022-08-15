package com.durys.jakub.companymanagement.request.leave_request.repository;

import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findAllByEmployeeId(Long employeeId);
}
