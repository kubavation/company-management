package com.durys.jakub.companymanagement.leaveRequestDDD.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode
public class LeaveRequestId implements Serializable {
    private final Long id;
}
