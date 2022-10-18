package com.durys.jakub.companymanagement.request.leave_request.controller;

import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;
import com.durys.jakub.companymanagement.shared.model.KeyValue;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/leave-privileges")
@AllArgsConstructor
public class LeavePrivilegesContoller {

    @GetMapping("/types")
    public Set<KeyValue<?>> getLeaveRequestTypes() {
        return Arrays.stream(LeaveRequestType.values())
                .map(type -> KeyValue.of(type.getName(), type.getShortcut()))
                .collect(Collectors.toSet());
    }

}
