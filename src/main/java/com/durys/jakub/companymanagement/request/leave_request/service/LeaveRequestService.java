package com.durys.jakub.companymanagement.request.leave_request.service;

import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.repository.LeaveRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public List<LeaveRequest> findAllByEmployeeId(Long employeeId) {
        return leaveRequestRepository.findAllByEmployeeId(employeeId);
    }
}
