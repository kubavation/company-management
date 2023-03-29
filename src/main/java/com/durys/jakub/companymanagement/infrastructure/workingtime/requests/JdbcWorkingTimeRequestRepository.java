package com.durys.jakub.companymanagement.infrastructure.workingtime.requests;

import com.durys.jakub.companymanagement.domain.workingtime.requests.RequestInWorkflow;
import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.WorkingTimeRequestId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
public class JdbcWorkingTimeRequestRepository implements WorkingTimeRequestRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public RequestInWorkflow load(WorkingTimeRequestId id) {
        return null;
    }

    @Override
    public void save(RequestInWorkflow request) {

    }
}
