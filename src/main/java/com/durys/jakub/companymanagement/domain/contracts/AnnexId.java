package com.durys.jakub.companymanagement.domain.contracts;


import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
@EqualsAndHashCode
class AnnexId implements Serializable {
    private final UUID value;
}
