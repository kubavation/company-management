package com.durys.jakub.companymanagement.absences.leaverequests.infrastructure.model;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.request.leave_request.model.converter.LeaveRequestTypeConverter;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.Status;
import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "CM_LEAVE_REQUEST")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeaveRequestEntity implements CmEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = StatusConverter.class)
    private Status status;

    @Convert(converter = LeaveRequestTypeConverter.class)
    private LeaveRequestType type;

    @Column(name = "DATE_FROM")
    private LocalDateTime dateFrom;

    @Column(name = "DATE_TO")
    private LocalDateTime dateTo;

    private BigDecimal days;
    private BigDecimal hours;

    private Long employeeId;

    private Long acceptingId;
}
