package com.durys.jakub.companymanagement.domain.workingtime.requests;

public class WorkOffRequest implements WorkingTimeRequest {

    private final WorkingTimeRequestId id;
    private final RequestInformation information;
    private final Author author;

    public WorkOffRequest(WorkingTimeRequestId id, Author author, RequestInformation information) {
        this.id = id;
        this.author = author;
        this.information = information;
    }

    @Override
    public WorkingTimeRequestId id() {
        return id;
    }

    @Override
    public Author author() {
        return author;
    }

    @Override
    public RequestInformation information() {
        return information;
    }
}
