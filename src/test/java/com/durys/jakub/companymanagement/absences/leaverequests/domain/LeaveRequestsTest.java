package com.durys.jakub.companymanagement.absences.leaverequests.domain;

import com.durys.jakub.companymanagement.application.leaverequests.LeaveRequestsApplicationService;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeavePrivilegesRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class LeaveRequestsTest {


    @Mock
    LeaveRequestRepository leaveRequestRepository;

    @Mock
    LeavePrivilegesRepository leavePrivilegesRepository;

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    private LeaveRequestsApplicationService leaveRequestsApplicationService;

    @Test
    void submitLeaveRequest_shouldSaveRequest() {

    }

}