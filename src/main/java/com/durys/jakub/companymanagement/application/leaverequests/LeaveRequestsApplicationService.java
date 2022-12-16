package com.durys.jakub.companymanagement.application.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.*;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.factory.LeaveRequestFactory;
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

@Service
@RequiredArgsConstructor
public class LeaveRequestsApplicationService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;


    public void submitLeaveRequest(ApplicantId applicantId, LeaveRequestType type, LocalDateTime from, LocalDateTime to) {

        Applicant applicant = employeeRepository.load(applicantId);

        LeaveRequest leaveRequest = LeaveRequestFactory.create(type, applicant, from, to);
        applicant.submitLeaveRequest(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }

    public void sendRequestToAcceptant(LeaveRequestId leaveRequestId, AcceptantId acceptantId) {

        LeaveRequest leaveRequest = leaveRequestRepository.load(leaveRequestId);

        if (Objects.isNull(leaveRequest)) {
            throw new EntityNotFoundException();
        }

        Applicant applicant = leaveRequest.getApplicant();

        Acceptant acceptant = employeeRepository.load(acceptantId);

        applicant.sendToAcceptant(leaveRequest, acceptant);

        leaveRequestRepository.save(leaveRequest);
    }

    public void cancelLeaveRequest(LeaveRequestId leaveRequestId) {

        LeaveRequest leaveRequest = leaveRequestRepository.load(leaveRequestId);

        Applicant applicant = leaveRequest.getApplicant();
        applicant.cancel(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }

    public void deleteLeaveRequest(LeaveRequestId leaveRequestId) {

        LeaveRequest leaveRequest = leaveRequestRepository.load(leaveRequestId);

        Applicant applicant = leaveRequest.getApplicant();
        applicant.delete(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }

    public void acceptLeaveRequest(LeaveRequestId leaveRequestId) {
        LeaveRequest leaveRequest = leaveRequestRepository.load(leaveRequestId);

        Acceptant acceptant = leaveRequest.getAcceptant();
        acceptant.accept(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }

    public void rejectLeaveRequest(LeaveRequestId leaveRequestId) {
        LeaveRequest leaveRequest = leaveRequestRepository.load(leaveRequestId);

        Acceptant acceptant = leaveRequest.getAcceptant();
        acceptant.reject(leaveRequest);

        leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest loadLeaveRequest(LeaveRequestId leaveRequestId) {
        return leaveRequestRepository.load(leaveRequestId);
    }


}
