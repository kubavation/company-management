package com.durys.jakub.companymanagement.shared.repository;

import com.durys.jakub.companymanagement.shared.enums.Status;
import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@NoRepositoryBean
public interface CmRepository<T extends CmEntity<ID>, ID extends Serializable> extends JpaRepository<T,ID> {


    default T safeDelete(T entity) {
        entity.setStatus(Status.DELETED);
        return save(entity);
    }
}