package com.durys.jakub.companymanagement.request.personal_request.model.dto.creational;


import com.durys.jakub.companymanagement.request.personal_request.model.dto.general.PersonalRequestFieldDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePersonalRequest {
    private Long employeeId;
    private Long requestTypeId;
    private List<CreatePersonalRequestField> fields;
}
