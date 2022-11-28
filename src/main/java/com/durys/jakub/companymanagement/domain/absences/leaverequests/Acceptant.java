package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;

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
