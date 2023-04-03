package com.durys.jakub.companymanagement.infrastructure.workingtime.requests.output;

import com.durys.jakub.companymanagement.infrastructure.employees.output.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "CM_WORKING_TIME_REQUEST")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkingTimeRequestEntity {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    private LocalDate day;

    private LocalTime from;
    private LocalTime to;

    @Enumerated(EnumType.STRING)
    private WorkingTimeRequestStatus status;
}
