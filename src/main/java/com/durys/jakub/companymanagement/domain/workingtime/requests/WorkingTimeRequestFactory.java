package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WorkingTimeRequestFactory {

    public static RequestInWorkflow instanceFrom(@NonNull WorkingTimeRequest request, @NonNull WorkingTimeRequestStatus status) {
        return switch (status) {
            case SUBMITTED -> new SubmittedWorkingTimeRequest(request);
            case ACCEPTED -> new AcceptedWorkingTimeRequest(request);
            case CANCELLED -> new CancelledWorkingTimeRequest(request);
            case REJECTED -> new RejectedWorkingTimeRequest(request);
            case SENT_FOR_ACCEPTATION -> new SentForAcceptationWorkingTimeRequest(request);
        };
    }

    public static WorkingTimeRequest from(WorkingTimeRequest.WorkInProgress wip) {
        return switch (wip.getType()) {
            case PRIVATE_EXIT -> new PrivateExitRequest(wip.getRequestId(), wip.getEmployeeId(), wip.getAtDay(), wip.getPeriod());
            case WORK_OFF -> new WorkOffRequest(wip.getRequestId(), wip.getEmployeeId(), wip.getAtDay(), wip.getPeriod());
        };
    }

}
