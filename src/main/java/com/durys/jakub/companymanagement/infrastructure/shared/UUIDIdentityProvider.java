package com.durys.jakub.companymanagement.infrastructure.shared;

import com.durys.jakub.companymanagement.commons.IdentityProvider;

import java.util.UUID;

class UUIDIdentityProvider implements IdentityProvider<UUID> {

    @Override
    public UUID nextId() {
        return UUID.randomUUID();
    }
}
