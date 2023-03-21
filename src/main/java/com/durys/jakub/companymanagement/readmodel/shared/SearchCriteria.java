package com.durys.jakub.companymanagement.readmodel.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCriteria {
    private Integer pageNumber;
    private Integer itemsPerPage;
    private String orderBy;
    private boolean ascending;
}
