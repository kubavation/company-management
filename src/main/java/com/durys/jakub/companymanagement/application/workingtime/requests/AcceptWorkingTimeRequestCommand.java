package com.durys.jakub.companymanagement.application.workingtime.requests;

import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestId;

public record AcceptWorkingTimeRequestCommand(WorkingTimeRequestId requestId) {
}
