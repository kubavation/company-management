package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.commons.domain.DomainServicesRegistry;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.events.LeaveRequestAcceptedEvent;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.RequiredArgsConstructor;

@AggregateRoot
@RequiredArgsConstructor
public class Acceptant implements Employable {

    private final AcceptantId acceptantId;


    public void accept(LeaveRequest leaveRequest) {

        leaveRequest.markAsAccepted();

        DomainServicesRegistry
                .instanceOf(LeaveRequestAcceptationService.class)
                .affectPermissions(
                        new LeaveRequestAcceptedEvent(
                            leaveRequest.getApplicantId(),
                            leaveRequest.getRequestType(),
                            leaveRequest.getPeriod().quantity())
                );
    }

    public void reject(LeaveRequest leaveRequest) {
        leaveRequest.markAsRejected();
    }


    @Override
    public EmployeeId employeeId() {
        return acceptantId;
    }

    public AcceptantId id() {
        return acceptantId;
    }
}
