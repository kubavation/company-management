package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.output;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestStatus;
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
@Table(name = "CM_LEAVE_REQUEST")
public class LeaveRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private LeaveRequestStatus requestStatus;

    private String type;

    @Column(name = "DATE_FROM")
    private LocalDateTime dateFrom;

    @Column(name = "DATE_TO")
    private LocalDateTime dateTo;

    private BigDecimal days;
    private BigDecimal hours;

    @Column(name = "EMPLOYEE_ID")
    private UUID employeeId;

    @Column(name = "ACCEPTING_ID")
    private UUID acceptingId;

    @Convert(converter = StatusDBConverter.class)
    private Status status = Status.ACTIVE;
}
