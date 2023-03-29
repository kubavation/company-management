package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.RequestInformation;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WorkingTimeRequestFactory {

    public static WorkingTimeRequest instanceFrom(WorkInProgress wip) {
        return switch (wip.getType()) {
            case PRIVATE_EXIT -> new PrivateExitRequest(wip.getRequestId(),
                    new Author(wip.getEmployeeId().value()), new RequestInformation(wip.getAtDay(), wip.getPeriod()));
            case WORK_OFF -> new WorkOffRequest(wip.getRequestId(),
                    new Author(wip.getEmployeeId().value()), new RequestInformation(wip.getAtDay(), wip.getPeriod()));
            case OVERTIME -> new OvertimeRequest(wip.getRequestId(),
                    new Author(wip.getEmployeeId().value()), new RequestInformation(wip.getAtDay(), wip.getPeriod()));
            case OVERTIME_TAKEN -> new OvertimeTakenRequest(wip.getRequestId(),
                    new Author(wip.getEmployeeId().value()), new RequestInformation(wip.getAtDay(), wip.getPeriod()));
        };
    }

}
