package com.durys.jakub.companymanagement.request.leave_request.service;

import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestFilterDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import com.durys.jakub.companymanagement.request.leave_request.repository.LeaveRequestRepository;
import com.durys.jakub.companymanagement.request.leave_request.util.LeaveRequestFilterUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public List<LeaveRequest> findAllByEmployeeId(Long employeeId) {
        return leaveRequestRepository.findAllByEmployeeId(employeeId);
    }

    public List<LeaveRequest> findAllByEmployeeIdAndRequestType(Long employeeId, LeaveRequestType type) {
        return leaveRequestRepository.findAllByEmployeeIdAndType(employeeId, type);
    }

    public List<LeaveRequest> findAllByFilters(Long employeeId, LeaveRequestFilterDTO filters) {
   

        Specification<LeaveRequest> specification = LeaveRequestFilterUtil.buildSpecification(filters);

        return leaveRequestRepository.findAll(specification);
    }
}
