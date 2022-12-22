//package com.durys.jakub.companymanagement.engagement.model;
//
//import com.durys.jakub.companymanagement.employee.model.entity.Employee;
//import com.durys.jakub.companymanagement.shared.converters.StatusConverter;
//import com.durys.jakub.companymanagement.shared.enums.Status;
//import lombok.*;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Table(name = "CM_ENGAGEMENT")
//@Entity
//@Builder
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Engagement {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
//
//    @Convert(converter = StatusConverter.class)
//    private Status status;
//
//    private LocalDateTime from;
//    private LocalDateTime to;
//
//}
