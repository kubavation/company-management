package com.durys.jakub.companymanagement.organisation_structure.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationDTO {

    private Long id;
    private String name;
    private Long level;
    private Long parentId;
    private List<OrganisationDTO> children = new ArrayList<>();
}
