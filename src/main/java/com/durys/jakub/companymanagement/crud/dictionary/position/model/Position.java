package com.durys.jakub.companymanagement.crud.dictionary.position.model;

import com.durys.jakub.companymanagement.crud.dictionary.general.model.CmDictionary;
import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import lombok.*;

import javax.persistence.*;

@Table(name = "CM_POSITION_DICT")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Position extends CmDictionary implements CmEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
}
