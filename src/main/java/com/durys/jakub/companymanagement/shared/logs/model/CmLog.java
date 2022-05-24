package com.durys.jakub.companymanagement.shared.logs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CM_LOG")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CmLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CLASS_NAME")
    private String className;

    @Column(name = "TABLE_NAME")
    private String tableName;

    @Column(name = "PRIMARY_KEY")
    private Long primaryKey;

    private String object;
    private LocalDateTime timestamp;
    private String operator;
}
