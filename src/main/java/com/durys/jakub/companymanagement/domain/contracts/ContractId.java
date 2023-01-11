package com.durys.jakub.companymanagement.domain.contracts;


import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@RequiredArgsConstructor
@EqualsAndHashCode
public class ContractId implements Serializable {
    private final UUID value;

    public static ContractId of(UUID value) {
        return new ContractId(value);
    }
}
