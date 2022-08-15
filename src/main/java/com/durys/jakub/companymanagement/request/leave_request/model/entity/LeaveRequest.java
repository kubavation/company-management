package com.durys.jakub.companymanagement.request.leave_request.model.entity;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.request.leave_request.model.converter.LeaveRequestTypeConverter;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
import com.durys.jakub.companymanagement.shared.enums.Status;
import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "CM_LEAVE_REQUEST")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LeaveRequest implements CmEntity<Long> {

    @Id
    private Long id;

    @Convert(converter = StatusConverter.class)
    private Status status;

    @Convert(converter = LeaveRequestTypeConverter.class)
    private LeaveRequestType type;

    private BigDecimal days;
    private BigDecimal hours;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "assistant_id")
    private Employee assistant;

    @ManyToOne
    @JoinColumn(name = "accepting_id")
    private Employee accepting;
}
