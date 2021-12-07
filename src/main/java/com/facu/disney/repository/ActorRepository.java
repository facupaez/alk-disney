package com.facu.disney.repository;

import com.facu.disney.entity.ActorEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long>, JpaSpecificationExecutor<ActorEntity> {

    // combinate filters
    List<ActorEntity> findAll(Specification<ActorEntity> spec);
}
