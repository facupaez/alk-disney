package com.facu.disney.repository;

import com.facu.disney.entity.Movie;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie>{
    
        // combinate filters
    List<Movie> findAll(Specification<Movie> spec);
}
