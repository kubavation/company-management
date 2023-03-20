package com.durys.jakub.companymanagement.readmodel.shared;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchCriteria {
    private Integer pageNumber;
    private Integer itemsPerPage;
    private String orderBy;
    private boolean ascending;
}
