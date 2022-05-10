package com.durys.jakub.companymanagement.request.personal_request.model.dto;

import com.durys.jakub.companymanagement.request.personal_request.model.entity.PersonalRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonalRequestFieldDTO {
    private Long id;
    private String value;

    @ManyToOne
    @JoinColumn(name = "PERSONAL_REQUEST_ID")
    private PersonalRequest personalRequest;
}
