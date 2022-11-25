package com.durys.jakub.companymanagement.absences.leaverequests.domain.vo;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode
public class LeaveRequestId implements Serializable {
    private final UUID id;
}
