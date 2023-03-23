package com.durys.jakub.companymanagement.domain.workingtime.requests;

import java.util.UUID;

public record Author(UUID authorId) {


    public SubmittedWorkingTimeRequest submit(WorkInProgress submittable) {
        return new SubmittedWorkingTimeRequest(WorkingTimeRequestFactory.fromWorkInProgress(submittable));
    }

    public CancelledWorkingTimeRequest cancel(RequestInWorkflow requestInWorkflow) {

        if (requestInWorkflow instanceof AcceptedWorkingTimeRequest) {
            throw new UnsupportedOperationException();
        }

        return new CancelledWorkingTimeRequest(requestInWorkflow.request());
    }


}
