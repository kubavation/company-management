package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeaveRequestFactory {

    public static LeaveRequest create(LeaveRequestId requestId, LeaveRequestType type, ApplicantId applicantId, LocalDateTime from, LocalDateTime to) {

        //todo explore domain
        if (type.equals(LeaveRequestType.CL)) {
            return new HourlyLeaveRequest(requestId, type, LeaveRequestHourlyPeriod.of(from, to), applicantId);
        }

        return new DailyLeaveRequest(requestId, type, LeaveRequestDailyPeriod.of(from.toLocalDate(), to.toLocalDate()), applicantId);
    }

    public static LeaveRequest create(LeaveRequest.WorkInProgress workInProgress) {
        return create(workInProgress.getRequestId(), workInProgress.getRequestType(), workInProgress.getApplicantId(), workInProgress.getPeriod().from, workInProgress.getPeriod().to);
    }
}
