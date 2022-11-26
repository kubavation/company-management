package com.durys.jakub.companymanagement.domain.absences.leaverequests.vo;

import lombok.*;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@EqualsAndHashCode
public class AuthorId implements Serializable {
    private final Long id;
}
