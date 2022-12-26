package com.durys.jakub.companymanagement.crud.personal_request.model.dto.creational;


import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreatePersonalRequest {
    private Long employeeId;
    private Long requestTypeId;
    private List<CreatePersonalRequestField> fields;
}
