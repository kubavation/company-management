package com.durys.jakub.companymanagement.absences.leaverequests.domain.vo;

import lombok.*;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode
public class AcceptantId implements Serializable {
    private final Long id;
}
