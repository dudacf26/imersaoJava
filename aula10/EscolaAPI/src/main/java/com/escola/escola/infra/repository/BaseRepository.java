package com.escola.escola.infra.repository;

import com.escola.escola.domain.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface BaseRepository<T extends BaseEntity> extends CrudRepository<T,Long> {
}
