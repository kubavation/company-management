package com.durys.jakub.companymanagement.domain.absences.leaverequests.factory;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeaveRequestFactory {

    public static LeaveRequest create(LeaveRequestType type, Applicant applicant, LocalDateTime from, LocalDateTime to) {

        if (type.equals(LeaveRequestType.CL)) { //TODO
            return new HourlyLeaveRequest(type, new LeaveRequestHourlyPeriod(from, to), applicant);
        }

        return new DailyLeaveRequest(type, new LeaveRequestDailyPeriod(from, to), applicant);
    }
}
