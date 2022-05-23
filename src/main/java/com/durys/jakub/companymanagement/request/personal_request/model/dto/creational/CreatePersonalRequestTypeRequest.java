package com.durys.jakub.companymanagement.request.personal_request.model.dto.creational;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePersonalRequestTypeRequest {
    private String name;
    private String desc;
}
