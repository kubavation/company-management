package com.durys.jakub.companymanagement.shared.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor(staticName = "of")
public class KeyValue<T> {
    private T key;
    private String value;
}
