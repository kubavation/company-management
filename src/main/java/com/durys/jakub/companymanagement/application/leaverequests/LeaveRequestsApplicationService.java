package com.durys.jakub.companymanagement.application.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestPeriod;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AuthorId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.infrastructure.leaverequests.LeaveRequestAggregateAssembler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LeaveRequestsApplicationService {

    private final LeaveRequestRepository leaveRequestRepository;


    public void submitLeaveRequest(Long authorId, String type, LocalDateTime from, LocalDateTime to) {

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.valueOf(type), new AuthorId(authorId), new LeaveRequestPeriod(from, to));

        leaveRequestRepository.save(leaveRequestAggregate);
    }

    public void sendRequestToAcceptant(UUID leaveRequestId, Long acceptantId) {

        LeaveRequestAggregate leaveRequestAggregate = leaveRequestRepository.load(new LeaveRequestId(leaveRequestId));

        if (Objects.isNull(leaveRequestAggregate)) {
            throw new EntityNotFoundException();
        }

        //todo check if acceptant is available
        leaveRequestAggregate.sendToAcceptant(new AcceptantId(acceptantId));
        
        leaveRequestRepository.save(leaveRequestAggregate);
    }


}
