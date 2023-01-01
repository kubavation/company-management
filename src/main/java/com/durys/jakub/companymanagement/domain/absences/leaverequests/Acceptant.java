package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.RequiredArgsConstructor;

@AggregateRoot
@RequiredArgsConstructor
public class Acceptant implements Employable {
    private final AcceptantId accptantId;


    public void accept(LeaveRequest leaveRequest) {
        leaveRequest.markAsAccepted();
    }

    public void reject(LeaveRequest leaveRequest) {
        leaveRequest.markAsRejected();
    }


    @Override
    public EmployeeId employeeId() {
        return accptantId;
    }
}
