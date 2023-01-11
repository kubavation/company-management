package com.durys.jakub.companymanagement.domain.contracts.vo;

import java.util.Objects;

public class Position {
    private final String name;

    public Position(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public String name() {
        return name;
    }
}
