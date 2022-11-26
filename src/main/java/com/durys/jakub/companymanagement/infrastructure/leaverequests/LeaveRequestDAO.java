package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


interface LeaveRequestDAO extends JpaRepository<LeaveRequestEntity, UUID> {

}
