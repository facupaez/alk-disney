package com.facu.disney.repository;

import com.facu.disney.entity.MovieEntity;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long>, JpaSpecificationExecutor<MovieEntity>{
    
        // combinate filters
    List<MovieEntity> findAll(Specification<MovieEntity> spec);
}
