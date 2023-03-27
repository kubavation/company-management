package com.durys.jakub.companymanagement.domain.workingtime.requests;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import com.durys.jakub.companymanagement.commons.domain.DomainServicesRegistry;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleId;
import com.durys.jakub.companymanagement.domain.workingtime.event.WorkingTimeRequestAcceptedEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class Acceptant {
    private final UUID acceptantId;
    private final String name;

    public AcceptedWorkingTimeRequest accept(SentForAcceptationWorkingTimeRequest request) {
        AcceptedWorkingTimeRequest accepted = new AcceptedWorkingTimeRequest(request);

        DomainServicesRegistry
                .instanceOf(WorkingTimeRequestService.class)
                .affectWorkingTimeSchedule(
                        new WorkingTimeRequestAcceptedEvent(
                            new ScheduleId(new EmployeeId(request.author().authorId()), request.information().atDay()),
                            WorkingTimeRequestType.PRIVATE_EXIT, //todo
                            request.information().period())
                );

        return accepted;
    }

    public RejectedWorkingTimeRequest reject(SentForAcceptationWorkingTimeRequest request) {
        return new RejectedWorkingTimeRequest(request);
    }

    public static Acceptant from(Employee employee) {
        return new Acceptant(employee.employeeId().value(), employee.name());
    }

}
