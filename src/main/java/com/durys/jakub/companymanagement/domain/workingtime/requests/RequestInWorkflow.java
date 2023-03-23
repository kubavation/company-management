package com.durys.jakub.companymanagement.domain.workingtime.requests;

public interface RequestInWorkflow {
    WorkingTimeRequest request();
    default Author author() {
        return request().author();
    }
}
