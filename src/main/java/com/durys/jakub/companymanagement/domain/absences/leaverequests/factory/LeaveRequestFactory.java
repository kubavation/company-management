package com.durys.jakub.companymanagement.domain.absences.leaverequests.factory;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.applicant.Applicant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeaveRequestFactory {

    public static LeaveRequest create(LeaveRequestType type, Applicant applicant, LocalDateTime from, LocalDateTime to) {

        if (type.equals(LeaveRequestType.CL)) {
            return new HourlyLeaveRequest(type, LeaveRequestHourlyPeriod.of(from, to), applicant);
        }

        return new DailyLeaveRequest(type, LeaveRequestDailyPeriod.of(from.toLocalDate(), to.toLocalDate()), applicant);
    }
}
