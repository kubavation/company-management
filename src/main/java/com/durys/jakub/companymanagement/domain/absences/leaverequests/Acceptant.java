package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.DomainEntity;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.Getter;

@DomainEntity
@Getter
public class Acceptant implements Employable {
    private final AcceptantId accptantId;

    public Acceptant(AcceptantId accptantId) {
        this.accptantId = accptantId;
    }

    public void accept(LeaveRequest leaveRequest) {
        leaveRequest.markAsAccepted();
    }

    public void reject(LeaveRequest leaveRequest) {
        leaveRequest.markAsRejected();
    }


    @Override
    public EmployeeId id() {
        return accptantId;
    }
}
