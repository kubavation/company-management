package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkInProgress implements WorkingTimeRequest.WithId, WorkingTimeRequest.OfType, WorkingTimeRequest.WithAuthor,
        WorkingTimeRequest.WithDay, WorkingTimeRequest.WithPeriodFrom, WorkingTimeRequest.WithPeriodTo, WorkingTimeRequest.Submittable {

    private WorkingTimeRequestId requestId;
    private EmployeeId employeeId;
    private LocalDate atDay;
    private LocalTime periodFrom;
    private WorkingTimeRequestPeriod period;
    private WorkingTimeRequestType type;

    public static WorkingTimeRequest.OfType builder(WorkingTimeRequestId requestId) {
        return new WorkInProgress().id(requestId);
    }

    @Override
    public WorkingTimeRequest.OfType id(WorkingTimeRequestId requestId) {
        this.requestId = requestId;
        return this;
    }

    @Override
    public WorkingTimeRequest.WithAuthor ofType(WorkingTimeRequestType type) {
        this.type = type;
        return this;
    }

    @Override
    public WorkInProgress author(EmployeeId employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    @Override
    public WorkInProgress at(LocalDate atDay) {
        this.atDay = atDay;
        return this;
    }

    @Override
    public WorkInProgress from(LocalTime time) {
        this.periodFrom = time;
        return this;
    }

    @Override
    public WorkingTimeRequest.Submittable to(LocalTime time) {
        this.period = new WorkingTimeRequestPeriod(this.periodFrom, time);
        return this;
    }

    @Override
    public SubmittedWorkingTimeRequest submit() {
        return new SubmittedWorkingTimeRequest(WorkingTimeRequestFactory.fromWorkInProgress(this));
    }

    WorkingTimeRequestId getRequestId() {
        return requestId;
    }

    EmployeeId getEmployeeId() {
        return employeeId;
    }

    LocalDate getAtDay() {
        return atDay;
    }

    WorkingTimeRequestPeriod getPeriod() {
        return period;
    }

    public WorkingTimeRequestType getType() {
        return type;
    }

}

