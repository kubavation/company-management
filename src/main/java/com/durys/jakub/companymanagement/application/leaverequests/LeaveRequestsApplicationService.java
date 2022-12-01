package com.durys.jakub.companymanagement.application.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LeaveRequestsApplicationService {

    private final LeaveRequestRepository leaveRequestRepository;

//    todo employee/applicant repo
//            retrieve acceptant/applicant and make changes  in leaveRequests

    public void submitLeaveRequest(Long applicantId, String type, LocalDateTime from, LocalDateTime to) {

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.valueOf(type), new Applicant(applicantId), new LeaveRequestPeriod(from, to));

        leaveRequestRepository.save(leaveRequestAggregate);
    }

    public void sendRequestToAcceptant(LeaveRequestId leaveRequestId, AcceptantId acceptantId) {

        LeaveRequestAggregate leaveRequestAggregate = leaveRequestRepository.load(leaveRequestId);

        if (Objects.isNull(leaveRequestAggregate)) {
            throw new EntityNotFoundException();
        }

        //todo check if acceptant is available
        leaveRequestAggregate.sendToAcceptant(new Acceptant(new AcceptantId(acceptantId)));

        leaveRequestRepository.save(leaveRequestAggregate);
    }

    public void cancelLeaveRequest(LeaveRequestId leaveRequestId) {
        LeaveRequestAggregate leaveRequestAggregate = leaveRequestRepository.load(leaveRequestId);
        leaveRequestAggregate.markAsCancelled();
        leaveRequestRepository.save(leaveRequestAggregate);
    }

    public void deleteLeaveRequest(LeaveRequestId leaveRequestId) {
        LeaveRequestAggregate leaveRequestAggregate = leaveRequestRepository.load(leaveRequestId);
        leaveRequestAggregate.markAsDeleted();
        leaveRequestRepository.save(leaveRequestAggregate);
    }

    public void acceptLeaveRequest(LeaveRequestId leaveRequestId) {
        LeaveRequestAggregate leaveRequestAggregate = leaveRequestRepository.load(leaveRequestId);
        leaveRequestAggregate.markAsAccepted();
        leaveRequestRepository.save(leaveRequestAggregate);
    }


}
