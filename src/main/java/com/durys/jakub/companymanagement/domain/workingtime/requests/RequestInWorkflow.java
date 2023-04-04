package com.durys.jakub.companymanagement.domain.workingtime.requests;

public sealed interface RequestInWorkflow permits AcceptedWorkingTimeRequest,
                    CancelledWorkingTimeRequest, RejectedWorkingTimeRequest,
                    SentForAcceptationWorkingTimeRequest, SubmittedWorkingTimeRequest {

    WorkingTimeRequest request();
    default Author author() {
        return request().author();
    }
}
