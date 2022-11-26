package com.durys.jakub.companymanagement.domain.absences.leaverequests.application.service;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LeaveRequestApplicationService {


    private final LeaveRequestRepository leaveRequestRepository;
}
