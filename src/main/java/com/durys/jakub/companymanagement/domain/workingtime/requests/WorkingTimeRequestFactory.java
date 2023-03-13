package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.NonNull;

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
}
