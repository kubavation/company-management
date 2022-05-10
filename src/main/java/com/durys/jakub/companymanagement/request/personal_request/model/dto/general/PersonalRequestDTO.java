package com.durys.jakub.companymanagement.request.personal_request.model.dto.general;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PersonalRequestDTO {

    private Long id;
    private Long employeeId;
    private Long requestTypeId;
    private List<PersonalRequestFieldDTO> fields;
}
