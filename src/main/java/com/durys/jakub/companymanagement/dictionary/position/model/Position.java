package com.durys.jakub.companymanagement.dictionary.position.model;

import com.durys.jakub.companymanagement.dictionary.general.model.CmDictionary;
import lombok.*;

import javax.persistence.*;

@Table(name = "CM_POSITION_DICT")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position extends CmDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
}
