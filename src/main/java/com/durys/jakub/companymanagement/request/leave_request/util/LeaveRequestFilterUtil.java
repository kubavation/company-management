package com.durys.jakub.companymanagement.request.leave_request.util;

import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest;
import com.durys.jakub.companymanagement.request.leave_request.model.entity.LeaveRequest_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeaveRequestFilterUtil {

    //https://reflectoring.io/spring-data-specifications/

    public static Specification<LeaveRequest> betweenDates(LocalDate dateFrom, LocalDate dateTo) {
        return (root, query, cb) -> cb.between(root.get(LeaveRequest_.DATE), dateFrom, dateTo);
    }

    public static Specification<LeaveRequest> withTypes(List<String> types) {
        return (root, query, cb) -> cb.in(root.get(LeaveRequest_.TYPE)).value(types);
    }
}
