package com.durys.jakub.companymanagement.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@NoRepositoryBean
public interface SafeDeleteRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {

    @Override
    @Modifying
    @Query(value = "UPDATE #{#entityName e} set e.status = 'H' where e.id = :entity.id ")
    void delete(@NonNull T entity);
}
