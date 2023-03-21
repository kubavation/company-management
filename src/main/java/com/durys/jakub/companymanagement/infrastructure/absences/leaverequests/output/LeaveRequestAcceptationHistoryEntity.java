package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.output;

import com.durys.jakub.companymanagement.infrastructure.employees.output.EmployeeEntity;
import com.durys.jakub.companymanagement.infrastructure.shared.status.Status;
import com.durys.jakub.companymanagement.infrastructure.shared.status.StatusDBConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "CM_LEAVE_REQUEST_ACCEPTATION_HISTORY")
public class LeaveRequestAcceptationHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "leave_request_id")
    private LeaveRequestEntity leaveRequest;

    @OneToOne
    @JoinColumn(name = "acceptant_id")
    private EmployeeEntity acceptant;

    private String status;
}
