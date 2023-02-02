package com.durys.jakub.companymanagement.shared.repository;

import com.durys.jakub.companymanagement.shared.enums.CmStatus;
import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CmRepository<T extends CmEntity<ID>, ID extends Serializable> extends JpaRepository<T,ID> {


    default T safeDelete(T entity) {
        entity.setStatus(CmStatus.DELETED);
        return save(entity);
    }
}