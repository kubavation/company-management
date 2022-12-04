package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.Entity;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.Getter;

@Entity
@Getter
public class Acceptant implements Employable {
    private final AcceptantId accptantId;

    public Acceptant(AcceptantId accptantId) {
        this.accptantId = accptantId;
    }

    public void accept(LeaveRequestAggregate leaveRequest) {
        leaveRequest.markAsAccepted();
    }

    public void reject(LeaveRequestAggregate leaveRequest) {
        leaveRequest.markAsRejected();
    }


    @Override
    public EmployeeId getId() {
        return accptantId;
    }
}
