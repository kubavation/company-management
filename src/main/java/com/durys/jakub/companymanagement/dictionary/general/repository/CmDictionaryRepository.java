package com.durys.jakub.companymanagement.dictionary.general.repository;

import com.durys.jakub.companymanagement.dictionary.general.model.CmDictionary;
import com.durys.jakub.companymanagement.shared.interfaces.CmEntity;
import com.durys.jakub.companymanagement.shared.repository.CmRepository;
import lombok.NonNull;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CmDictionaryRepository<T extends CmDictionary & CmEntity<ID> , ID extends Serializable>
        extends CmRepository<T,ID> {

    default <S extends T> S dictSave(S entity) {
        S saved = save(entity);
        return saved;
    }


//    @Modifying
//    @Query(value = "UPDATE #{#entityName} x set x.date_to = 1  where x.dictionary_id = :#{#entity.dictionary_id}")
//    void changeDateTo(@NonNull T entity);  TODO

}
