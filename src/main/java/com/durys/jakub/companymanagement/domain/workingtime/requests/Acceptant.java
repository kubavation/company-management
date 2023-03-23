package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class Acceptant {
    private final UUID acceptantId;
    private final String name;

    public AcceptedWorkingTimeRequest accept(SentForAcceptationWorkingTimeRequest request) {
        return new AcceptedWorkingTimeRequest(request);
    }

    public RejectedWorkingTimeRequest reject(SentForAcceptationWorkingTimeRequest request) {
        return new RejectedWorkingTimeRequest(request);
    }

    public static Acceptant from(Employee employee) {
        return new Acceptant(employee.employeeId().value(), employee.name());
    }

}
