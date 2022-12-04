package com.durys.jakub.companymanagement.request.leave_request.service;

import com.durys.jakub.companymanagement.request.leave_request.model.dto.CreateLeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestFilterDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import com.durys.jakub.companymanagement.request.leave_request.repository.JpaLeaveRequestRepository;
import com.durys.jakub.companymanagement.request.leave_request.util.LeaveRequestFilterUtil;
import com.durys.jakub.companymanagement.shared.enums.Status;
import com.durys.jakub.companymanagement.shared.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class LeaveRequestService {

    private final JpaLeaveRequestRepository jpaLeaveRequestRepository;

    public LeaveRequest findById(Long id) {
        return jpaLeaveRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(LeaveRequest.class, id));
    }

    public List<LeaveRequest> findAllByEmployeeId(Long employeeId) {
        return jpaLeaveRequestRepository.findAllByEmployeeId(employeeId);
    }

    public List<LeaveRequest> findAllByEmployeeIdAndRequestType(Long employeeId, LeaveRequestType type) {
        return jpaLeaveRequestRepository.findAllByEmployeeIdAndType(employeeId, type);
    }

    public List<LeaveRequest> findAllByFilters(LeaveRequestFilterDTO filters) {
        return jpaLeaveRequestRepository.findAll(LeaveRequestFilterUtil.buildSpecification(filters));
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
        jpaLeaveRequestRepository.save(leaveRequest);
    }

    public BigDecimal numberOfDaysBetween(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return BigDecimal.valueOf(ChronoUnit.DAYS.between(dateFrom, dateTo.plusDays(1)));
    }

    @Transactional
    public void delete(Long id) {
        LeaveRequest entity = jpaLeaveRequestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(LeaveRequest.class, id));
        entity.setStatus(Status.DELETED);
    }
}
