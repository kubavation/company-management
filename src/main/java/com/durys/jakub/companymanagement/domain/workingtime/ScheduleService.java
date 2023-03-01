package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.commons.domain.DomainService;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
}
