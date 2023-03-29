package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.RequestInformation;
import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.WorkingTimeRequestId;

import java.time.LocalDate;
import java.time.LocalTime;

public interface WorkingTimeRequest {
    WorkingTimeRequestId id();
    Author author();
    RequestInformation information();

    static OfType builder(WorkingTimeRequestId requestId) {
        return WorkInProgress.builder(requestId);
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
        WorkInProgress save();
    }
}
