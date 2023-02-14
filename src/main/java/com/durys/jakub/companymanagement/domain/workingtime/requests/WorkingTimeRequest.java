package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class WorkingTimeRequest {
    private final WorkingTimeRequestId requestId;
    private final EmployeeId authorId;
    private final LocalDate atDay;
    private final WorkingTimeRequestPeriod period;
    private WorkingTimeRequestStatus status;

    WorkingTimeRequest(WorkingTimeRequestId requestId, EmployeeId authorId, LocalDate atDay,
                              WorkingTimeRequestPeriod period, WorkingTimeRequestStatus status) {
        this.requestId = requestId;
        this.authorId = authorId;
        this.atDay = atDay;
        this.period = period;
        this.status = status;
    }

    public static WithAuthor builder() {
        return new WorkInProgress();
    }


    public static class WorkInProgress implements WithId, WithAuthor, WithDay,
            WithPeriodFrom, WithPeriodTo, Submittable {

        private WorkingTimeRequestId requestId;
        private EmployeeId employeeId;
        private LocalDate atDay;
        private LocalTime periodFrom;
        private LocalTime periodTo;
        private WorkingTimeRequestPeriod period;

        @Override
        public WithAuthor id(WorkingTimeRequestId requestId) {
            this.requestId = requestId;
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
        public Submittable to(LocalTime time) {
            this.periodTo = time;
            this.period = new WorkingTimeRequestPeriod(this.periodFrom, this.periodTo);
            return this;
        }

        @Override
        public WorkInProgress get() {
            return this;
        }
    }

    public interface WithId {
        WithAuthor id(WorkingTimeRequestId requestId);
    }

    public interface WithAuthor {
        WithDay author(EmployeeId employeeId);
    }

    public interface WithDay {
        WithPeriodFrom at(LocalDate atDay);
    }

    public interface WithPeriodFrom {
        WithPeriodTo from(LocalTime time);
    }

    public interface WithPeriodTo {
        Submittable to(LocalTime time);
    }

    interface Submittable {
        WorkInProgress get();
    }
}
