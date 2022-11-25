package com.durys.jakub.companymanagement.absences.leaverequests.application.service;

import com.durys.jakub.companymanagement.absences.leaverequests.domain.LeaveRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LeaveRequestApplicationService {


    private final LeaveRequestRepository leaveRequestRepository;
}
