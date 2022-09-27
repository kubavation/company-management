package com.durys.jakub.companymanagement.request.leave_request.util;

import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeaveRequestFilterUtil {

    public static Specification<LeaveRequest> betweenDates(LocalDate dateFrom, LocalDate dateTo) {
        return (root, query, cb) -> null;
    }
}
