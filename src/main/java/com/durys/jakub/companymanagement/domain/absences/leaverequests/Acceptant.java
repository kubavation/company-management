package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.commons.domain.DomainServicesRegistry;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.events.LeaveRequestAcceptedEvent;
import com.durys.jakub.companymanagement.domain.employees.Employable;
import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import com.durys.jakub.companymanagement.domain.sharedkernel.TenantId;
import lombok.RequiredArgsConstructor;

@AggregateRoot
@RequiredArgsConstructor
public class Acceptant implements Employable {

    private final AcceptantId acceptantId;
    private final TenantId tenantId;


    public void accept(LeaveRequest leaveRequest) {

        leaveRequest.markAsAccepted();

        DomainServicesRegistry
                .instanceOf(LeaveRequestAcceptationService.class)
                .affectPermissions(
                        new LeaveRequestAcceptedEvent(
                            leaveRequest.getApplicantId(),
                            leaveRequest.getRequestType(),
                            leaveRequest.getPeriod().quantity(),
                            leaveRequest.getPeriod().getFrom(), leaveRequest.getPeriod().getTo())
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

    public TenantId tenantId() {
        return tenantId;
    }
}
