package com.durys.jakub.companymanagement.application.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
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

    private final EmployeeRepository employeeRepository;


    public void submitLeaveRequest(ApplicantId applicantId, LeaveRequestType type, LocalDateTime from, LocalDateTime to) {

        Applicant applicant = employeeRepository.load(applicantId);

        LeaveRequestAggregate leaveRequestAggregate = applicant.submitLeaveRequest(type, new LeaveRequestPeriod(from, to));

        leaveRequestRepository.save(leaveRequestAggregate);
    }

    public void sendRequestToAcceptant(ApplicantId applicantId, LeaveRequestId leaveRequestId, AcceptantId acceptantId) {

        Applicant applicant = employeeRepository.load(applicantId);

        LeaveRequestAggregate leaveRequest = leaveRequestRepository.load(leaveRequestId);

        if (Objects.isNull(leaveRequest)) {
            throw new EntityNotFoundException();
        }

        Acceptant acceptant = employeeRepository.load(acceptantId);

        applicant.send(leaveRequest, acceptant);

        leaveRequestRepository.save(leaveRequest);
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
