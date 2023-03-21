package com.durys.jakub.companymanagement.readmodel.shared;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchCriteriaBuilderService {

    private static final String LIMIT_AND_OFFSET_CLAUSE = " LIMIT %d OFFSET %d";

    public static String appendCriteria(String sql, SearchCriteria searchCriteria) {
        return sql + LIMIT_AND_OFFSET_CLAUSE.formatted(
                searchCriteria.getItemsPerPage(), offsetFrom(searchCriteria.getPageNumber(), searchCriteria.getItemsPerPage()));
    }

    private static Integer offsetFrom(Integer pageNumber, Integer itemsPerPage) {
        return pageNumber * itemsPerPage;
    }

}
