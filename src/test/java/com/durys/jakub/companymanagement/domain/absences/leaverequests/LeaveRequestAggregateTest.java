package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidLeaveRequestPeriodException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidStatusForOperationException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.OperationUnavailableException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.ApplicantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestStatus;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class LeaveRequestAggregateTest {


    @Test
    void submitLeaveRequest_shouldSubmitLeaveRequest() {
        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(LocalDateTime.now(), LocalDateTime.now())
        );

        assertEquals(LeaveRequestStatus.SUBMITTED, leaveRequestAggregate.getStatus());
    }


    @Test
    void deleteLeaveRequest_shouldMarkLeaveRequestAsDeleted() {
        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(LocalDateTime.now(), LocalDateTime.now())
        );

        leaveRequestAggregate.markAsDeleted();

        assertEquals(LeaveRequestStatus.DELETED, leaveRequestAggregate.getStatus());
    }

    @Test
    void deleteLeaveRequest_shouldThrowInvalidStatusForOperationException() {
        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(LocalDateTime.now(), LocalDateTime.now())
        );
        leaveRequestAggregate.markAsRejected();



        assertThrows(InvalidStatusForOperationException.class, leaveRequestAggregate::markAsDeleted);
    }


    @Test
    void sendLeaveRequestToAcceptant_shouldSendToAcceptant() {

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(LocalDateTime.now(), LocalDateTime.now())
        );

        Acceptant acceptant = new Acceptant(new AcceptantId(UUID.randomUUID()));


        leaveRequestAggregate.sendToAcceptant(acceptant);

        assertEquals(LeaveRequestStatus.SEND_FOR_ACCEPTATION, leaveRequestAggregate.getStatus());
        assertEquals(acceptant.getAccptantId(), leaveRequestAggregate.getAcceptant().getAccptantId());
    }

    @Test
    void sendLeaveRequestToAcceptant_shouldThrowInvalidStatusForOperationException() {

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(LocalDateTime.now(), LocalDateTime.now())
        );

        leaveRequestAggregate.markAsDeleted();
        Acceptant acceptant = new Acceptant(new AcceptantId(UUID.randomUUID()));


        assertThrows(InvalidStatusForOperationException.class, () -> leaveRequestAggregate.sendToAcceptant(acceptant));
    }



    @Test
    void sendLeaveRequestToAcceptant_shouldThrowExceptionWhenAcceptantIsNull() {

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(LocalDateTime.now(), LocalDateTime.now())
        );

        assertThrows(RuntimeException.class, () -> leaveRequestAggregate.sendToAcceptant(null));
    }


    @Test
    void acceptLeaveRequest_shouldMarkLeaveRequestAsAccepted() {

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(LocalDateTime.now(), LocalDateTime.now())
        );

        leaveRequestAggregate.sendToAcceptant(new Acceptant(new AcceptantId(UUID.randomUUID())));

        leaveRequestAggregate.markAsAccepted();

        assertEquals(LeaveRequestStatus.ACCEPTED, leaveRequestAggregate.getStatus());
    }

    @Test
    void acceptLeaveRequest_shouldThrowInvalidStatusForOperationException() {

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(LocalDateTime.now(), LocalDateTime.now())
        );

        assertThrows(InvalidStatusForOperationException.class, leaveRequestAggregate::markAsAccepted);
    }


    @Test
    void rejectLeaveRequest_shouldMarkLeaveRequestAsRejected() {

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(LocalDateTime.now(), LocalDateTime.now())
        );

        leaveRequestAggregate.markAsRejected();

        assertEquals(LeaveRequestStatus.REJECTED, leaveRequestAggregate.getStatus());
    }


    @Test
    void cancelLeaveRequest_shouldMarkLeaveRequestAsCanceled() {

        LocalDateTime dateFrom = LocalDateTime.now().plusHours(1);

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(dateFrom, dateFrom)
        );

        leaveRequestAggregate.markAsCancelled();

        assertEquals(LeaveRequestStatus.CANCELLED, leaveRequestAggregate.getStatus());
    }

    @Test
    void cancelLeaveRequest_shouldThrowInvalidStatusForOperationException() {

        LocalDateTime dateFrom = LocalDateTime.now().plusHours(1);

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(dateFrom, dateFrom)
        );
        leaveRequestAggregate.markAsDeleted();


        assertThrows(InvalidStatusForOperationException.class, leaveRequestAggregate::markAsCancelled);;
    }

    @Test
    void cancelLeaveRequest_shouldThrowOperationUnavailableException() {

        LocalDateTime dateFrom = LocalDateTime.now().minusHours(1);

        LeaveRequestAggregate leaveRequestAggregate = new LeaveRequestAggregate(
                LeaveRequestType.AL, new Applicant(new ApplicantId(UUID.randomUUID())), new LeaveRequestPeriod(dateFrom, dateFrom)
        );

        assertThrows(OperationUnavailableException.class, leaveRequestAggregate::markAsCancelled);;
    }


}