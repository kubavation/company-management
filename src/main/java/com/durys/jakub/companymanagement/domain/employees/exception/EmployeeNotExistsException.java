package com.durys.jakub.companymanagement.domain.employees.exception;

public class EmployeeNotExistsException extends RuntimeException {

    public EmployeeNotExistsException() {
        super("Employee not exists");
    }
}
