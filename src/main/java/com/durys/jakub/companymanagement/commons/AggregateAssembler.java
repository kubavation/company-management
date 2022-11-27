package com.durys.jakub.companymanagement.commons;


public interface AggregateAssembler<T, R> {

    T toEntity(R aggregate);

    R toAggregate(T entity);

}
