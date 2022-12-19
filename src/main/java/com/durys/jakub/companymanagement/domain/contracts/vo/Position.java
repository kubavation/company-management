package com.durys.jakub.companymanagement.domain.contracts.vo;

import java.util.Objects;

class Position {
    private final String name;

    Position(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }
}
