package com.durys.jakub.companymanagement.request.leave_request.util;

import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestFilterDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest_;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeaveRequestFilterUtil {

    public static Specification<LeaveRequest> defaultValue() {
        return (root, query, cb) -> cb.isTrue(root.get(LeaveRequest_.ID).isNotNull());
    }
    public static Specification<LeaveRequest> withEmployeeId(Long employeeId) {
        return (root, query, cb) -> cb.equal(root.get(LeaveRequest_.EMPLOYEE), employeeId);
    }
    public static Specification<LeaveRequest> betweenDates(LocalDate dateFrom, LocalDate dateTo) {
        return (root, query, cb) -> cb.between(root.get(LeaveRequest_.DATE_FROM), dateFrom, dateTo);
    }

    public static Specification<LeaveRequest> withTypes(List<LeaveRequestType> types) {
        return (root, query, cb) -> cb.in(root.get(LeaveRequest_.TYPE)).value(types);
    }


    public static Specification<LeaveRequest> buildSpecification(LeaveRequestFilterDTO filters) {

        Specification<LeaveRequest> specification = defaultValue();

        if (!Objects.isNull(filters.getEmployeeId())) {
            specification = specification.and(withEmployeeId(filters.getEmployeeId()));
        }

        if (!Objects.isNull(filters.getDateFrom()) && !Objects.isNull(filters.getDateTo())) {
            specification =  specification.and(betweenDates(filters.getDateFrom(), filters.getDateTo()));
        }

        if (CollectionUtils.isNotEmpty(filters.getRequestType())) {
            specification = specification.and(withTypes(filters.getRequestType()));
        }



        return specification;
    }
}
