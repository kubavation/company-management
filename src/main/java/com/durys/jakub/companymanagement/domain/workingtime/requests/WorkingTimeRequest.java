package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.time.LocalTime;


public interface WorkingTimeRequest {
    WorkingTimeRequestId id();
    EmployeeId authorId();
    RequestInformation information();
}
// abstract class WorkingTimeRequest {
//
//     private final WorkingTimeRequestId requestId;
//     private final EmployeeId authorId;
//     private final LocalDate atDay;
//     private final WorkingTimeRequestPeriod period;
//
//     protected WorkingTimeRequest(WorkingTimeRequestId requestId, EmployeeId authorId, LocalDate atDay,
//                                  WorkingTimeRequestPeriod period) {
//         this.requestId = requestId;
//         this.authorId = authorId;
//         this.atDay = atDay;
//         this.period = period;
//     }
//     public static WithId builder() {
//         return new WorkInProgress();
//     }
//
// }

 public class WorkInProgress implements WithId, OfType, WithAuthor, WithDay,
            WithPeriodFrom, WithPeriodTo, Submittable {

        private WorkingTimeRequestId requestId;
        private EmployeeId employeeId;
        private LocalDate atDay;
        private LocalTime periodFrom;
        private WorkingTimeRequestPeriod period;
        private WorkingTimeRequestType type;

        @Override
        public OfType id(WorkingTimeRequestId requestId) {
            this.requestId = requestId;
            return this;
        }

        @Override
        public WithAuthor ofType(WorkingTimeRequestType type) {
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
        public Submittable to(LocalTime time) {
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

     interface WithId {
        OfType id(WorkingTimeRequestId requestId);
    }

     interface OfType {
        WithAuthor ofType(WorkingTimeRequestType type);
    }

     interface WithAuthor {
        WithDay author(EmployeeId employeeId);
    }

     interface WithDay {
        WithPeriodFrom at(LocalDate atDay);
    }

     interface WithPeriodFrom {
        WithPeriodTo from(LocalTime time);
    }

     interface WithPeriodTo {
        Submittable to(LocalTime time);
    }

     interface Submittable {
        SubmittedWorkingTimeRequest submit();
    }
}
