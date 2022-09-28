package com.durys.jakub.companymanagement.request.leave_request.util;

import com.durys.jakub.companymanagement.request.leave_request.model.dto.LeaveRequestFilterDTO;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeaveRequestFilterUtil {

    public static Specification<LeaveRequest> betweenDates(LocalDate dateFrom, LocalDate dateTo) {
        return (root, query, cb) -> cb.between(root.get(LeaveRequest_.DATE), dateFrom, dateTo);
    }

    public static Specification<LeaveRequest> withTypes(List<String> types) {
        return (root, query, cb) -> cb.in(root.get(LeaveRequest_.TYPE)).value(types);
    }


    public static Specification<LeaveRequest> buildSpecification(LeaveRequestFilterDTO filters) {

        if (!Objects.isNull(filters.getDateFrom()) && !Objects.isNull(filters.getDateTo())) {
            return betweenDates(filters.getDateFrom(), filters.getDateTo());
        }

        return null;
    }
}
