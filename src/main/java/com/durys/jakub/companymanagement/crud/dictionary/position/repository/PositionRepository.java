package com.durys.jakub.companymanagement.crud.dictionary.position.repository;

import com.durys.jakub.companymanagement.crud.dictionary.position.model.Position;
import com.durys.jakub.companymanagement.shared.repository.CmRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CmRepository<Position, Long> {
}