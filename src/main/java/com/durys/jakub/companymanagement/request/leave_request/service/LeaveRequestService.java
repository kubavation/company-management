package com.durys.jakub.companymanagement.request.leave_request.service;

import com.durys.jakub.companymanagement.request.leave_request.model.dto.CreateLeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestFilterDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import com.durys.jakub.companymanagement.request.leave_request.repository.LeaveRequestRepository;
import com.durys.jakub.companymanagement.request.leave_request.util.LeaveRequestFilterUtil;
import com.durys.jakub.companymanagement.shared.enums.Status;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequest findById(Long id) {
        return leaveRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(LeaveRequest.class, id));
    }

    public List<LeaveRequest> findAllByEmployeeId(Long employeeId) {
        return leaveRequestRepository.findAllByEmployeeId(employeeId);
    }

    public List<LeaveRequest> findAllByEmployeeIdAndRequestType(Long employeeId, LeaveRequestType type) {
        return leaveRequestRepository.findAllByEmployeeIdAndType(employeeId, type);
    }

    public List<LeaveRequest> findAllByFilters(LeaveRequestFilterDTO filters) {
        return leaveRequestRepository.findAll(LeaveRequestFilterUtil.buildSpecification(filters));
    }

    public LeaveRequest prepareEntity(CreateLeaveRequest createLeaveRequest) {
        return LeaveRequest.builder()
                .dateFrom(createLeaveRequest.getDateFrom())
                .dateTo(createLeaveRequest.getDateTo())
                .status(Status.ACTIVE)
                .hours(BigDecimal.ZERO)
                .type(createLeaveRequest.getType())
                .build();
    }

    public void save(LeaveRequest leaveRequest) {
        leaveRequestRepository.save(leaveRequest);
    }

    public BigDecimal numberOfDaysBetween(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return BigDecimal.valueOf(ChronoUnit.DAYS.between(dateFrom, dateTo.plusDays(1)));
    }

    @Transactional
    public void delete(Long id) {
        LeaveRequest entity = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(LeaveRequest.class, id));
        entity.setStatus(Status.DELETED);
    }
}
