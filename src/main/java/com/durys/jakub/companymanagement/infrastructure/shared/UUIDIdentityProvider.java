package com.durys.jakub.companymanagement.infrastructure.shared;

import com.durys.jakub.companymanagement.commons.IdentityProvider;

import java.util.UUID;

public class UUIDIdentityProvider implements IdentityProvider {

    @Override
    public UUID nextId() {
        return UUID.randomUUID();
    }
}
