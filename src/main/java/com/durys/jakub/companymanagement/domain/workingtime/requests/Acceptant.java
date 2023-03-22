package com.durys.jakub.companymanagement.domain.workingtime.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class Acceptant {
    private final UUID acceptantId;
    private final String name;
}
