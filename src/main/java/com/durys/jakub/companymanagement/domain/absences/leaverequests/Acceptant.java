package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.Entity;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import lombok.Getter;

@Entity
@Getter
public class Acceptant {
    private final AcceptantId accptantId;
    public Acceptant(AcceptantId accptantId) {
        this.accptantId = accptantId;
    }

    public void accept(LeaveRequestAggregate leaveRequest) {
        leaveRequest.markAsAccepted();
    }

    public void reject(LeaveRequestAggregate leaveRequest) {
        leaveRequest.markAsAccepted();
    }

}
