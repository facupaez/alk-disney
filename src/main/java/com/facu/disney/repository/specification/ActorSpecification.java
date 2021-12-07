package com.facu.disney.repository.specification;

import com.facu.disney.dto.ActorFiltersDTO;
import com.facu.disney.entity.ActorEntity;
import com.facu.disney.entity.MovieEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
public class ActorSpecification {

    public Specification<ActorEntity> getActorByFilters(ActorFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"));
            }

            if (filtersDTO.getAge() != null) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("age")),
                                "%" + filtersDTO.getAge() + "%"));
            }
            

            if (!CollectionUtils.isEmpty(filtersDTO.getMovies())) {
                Join<MovieEntity, ActorEntity> join = root.join("movies", JoinType.INNER);
                Expression<String> moviesId = join.get("idMovie");
                predicates.add(moviesId.in(filtersDTO.getMovies()));
            }

            //remove duplicates
            query.distinct(true);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
