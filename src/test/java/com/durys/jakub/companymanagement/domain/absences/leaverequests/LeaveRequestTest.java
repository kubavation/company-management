package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.acceptant.Acceptant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.applicant.Applicant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidStatusForOperationException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.OperationUnavailableException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.acceptant.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.applicant.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestStatus;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LeaveRequestTest {


    @Test
    void submitLeaveRequest_shouldSubmitLeaveRequest() {
        LeaveRequest leaveRequest = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(LocalDate.now(), LocalDate.now()),  new Applicant(new ApplicantId(UUID.randomUUID()))
        );

        assertEquals(LeaveRequestStatus.SUBMITTED, leaveRequest.getStatus());
    }


    @Test
    void deleteLeaveRequest_shouldMarkLeaveRequestAsDeleted() {
        LeaveRequest leaveRequest  = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(LocalDate.now(), LocalDate.now()), new Applicant(new ApplicantId(UUID.randomUUID()))
        );

        leaveRequest.markAsDeleted();

        assertEquals(LeaveRequestStatus.DELETED, leaveRequest.getStatus());
    }

    @Test
    void deleteLeaveRequest_shouldThrowInvalidStatusForOperationException() {
        LeaveRequest leaveRequest = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(LocalDate.now(), LocalDate.now()), new Applicant(new ApplicantId(UUID.randomUUID()))
        );

        leaveRequest.markAsRejected();

        assertThrows(InvalidStatusForOperationException.class, leaveRequest::markAsDeleted);
    }


    @Test
    void sendLeaveRequestToAcceptant_shouldSendToAcceptant() {

        LeaveRequest leaveRequest  = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(LocalDate.now(), LocalDate.now()),
                new Applicant(new ApplicantId(UUID.randomUUID()))
        );

        Acceptant acceptant = new Acceptant(new AcceptantId(UUID.randomUUID()));


        leaveRequest.setAcceptant(acceptant);

        assertEquals(LeaveRequestStatus.SEND_FOR_ACCEPTATION, leaveRequest.getStatus());
        assertEquals(acceptant.getAccptantId(), leaveRequest.getAcceptant().getAccptantId());
    }

    @Test
    void sendLeaveRequestToAcceptant_shouldThrowInvalidStatusForOperationException() {

        LeaveRequest leaveRequest = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(LocalDate.now(), LocalDate.now()), new Applicant(new ApplicantId(UUID.randomUUID()))
                );

        leaveRequest.markAsDeleted();
        Acceptant acceptant = new Acceptant(new AcceptantId(UUID.randomUUID()));


        assertThrows(InvalidStatusForOperationException.class, () -> leaveRequest.setAcceptant(acceptant));
    }



    @Test
    void sendLeaveRequestToAcceptant_shouldThrowExceptionWhenAcceptantIsNull() {

        LeaveRequest leaveRequest = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(LocalDate.now(), LocalDate.now()), new Applicant(new ApplicantId(UUID.randomUUID()))
        );

        assertThrows(RuntimeException.class, () -> leaveRequest.setAcceptant(null));
    }


    @Test
    void acceptLeaveRequest_shouldMarkLeaveRequestAsAccepted() {

        LeaveRequest leaveRequest = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(LocalDate.now(), LocalDate.now()), new Applicant(new ApplicantId(UUID.randomUUID()))
        );

        leaveRequest.setAcceptant(new Acceptant(new AcceptantId(UUID.randomUUID())));
        leaveRequest.markAsAccepted();

        assertEquals(LeaveRequestStatus.ACCEPTED, leaveRequest.getStatus());
    }

    @Test
    void acceptLeaveRequest_shouldThrowInvalidStatusForOperationException() {

        LeaveRequest leaveRequest = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(LocalDate.now(), LocalDate.now()), new Applicant(new ApplicantId(UUID.randomUUID()))
        );

        assertThrows(InvalidStatusForOperationException.class, leaveRequest::markAsAccepted);
    }


    @Test
    void rejectLeaveRequest_shouldMarkLeaveRequestAsRejected() {

        LeaveRequest leaveRequest = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(LocalDate.now(), LocalDate.now()), new Applicant(new ApplicantId(UUID.randomUUID()))
        );

        leaveRequest.markAsRejected();

        assertEquals(LeaveRequestStatus.REJECTED, leaveRequest.getStatus());
    }


    @Test
    void cancelLeaveRequest_shouldMarkLeaveRequestAsCanceled() {

        LocalDate dateFrom = LocalDate.now().plusDays(1);

        LeaveRequest leaveRequest = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(dateFrom, dateFrom), new Applicant(new ApplicantId(UUID.randomUUID()))
        );

        leaveRequest.markAsCancelled();

        assertEquals(LeaveRequestStatus.CANCELLED, leaveRequest.getStatus());
    }

    @Test
    void cancelLeaveRequest_shouldThrowInvalidStatusForOperationException() {

        LocalDate dateFrom = LocalDate.now().plusDays(1);

        LeaveRequest leaveRequest = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(dateFrom, dateFrom), new Applicant(new ApplicantId(UUID.randomUUID()))
        );
        leaveRequest.markAsDeleted();


        assertThrows(InvalidStatusForOperationException.class, leaveRequest::markAsCancelled);
    }

    @Test
    void cancelLeaveRequest_shouldThrowOperationUnavailableException() {

        LocalDate dateFrom = LocalDate.now().minusDays(1);

        LeaveRequest leaveRequest = new DailyLeaveRequest(
                LeaveRequestType.AL, LeaveRequestDailyPeriod.of(dateFrom, dateFrom), new Applicant(new ApplicantId(UUID.randomUUID()))
        );

        assertThrows(OperationUnavailableException.class, leaveRequest::markAsCancelled);;
    }


}