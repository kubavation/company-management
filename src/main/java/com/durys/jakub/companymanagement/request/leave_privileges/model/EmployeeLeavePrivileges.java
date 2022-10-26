package com.durys.jakub.companymanagement.request.leave_privileges.model;

import com.durys.jakub.companymanagement.employee.model.entity.Employee;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import com.durys.jakub.companymanagement.shared.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CM_EMPLOYEE_PRIVILEGES")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EmployeeLeavePrivileges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "leave_request_type")
    private LeaveRequestType leaveRequestType;

    private Integer year;
    private Integer days;
    private BigDecimal hours;

    private Status status;

}
