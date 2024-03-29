package com.durys.jakub.companymanagement.infrastructure.shared.identity;

import com.durys.jakub.companymanagement.commons.IdentityProvider;

import java.util.UUID;

public class UUIDIdentityProvider implements IdentityProvider {

    @Override
    public UUID nextId() {
        return UUID.randomUUID();
    }
}
