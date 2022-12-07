package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestStatus;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LeaveRequestAggregateTest {


    @Test
    void submitLeaveRequest_shouldSubmitLeaveRequest() {
        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(LocalDateTime.now(), LocalDateTime.now())
        );

        assertEquals(LeaveRequestStatus.SUBMITTED, leaveRequestAggregate.getStatus());
    }

}