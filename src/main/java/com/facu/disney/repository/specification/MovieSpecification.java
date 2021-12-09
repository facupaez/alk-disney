package com.facu.disney.repository.specification;

import com.facu.disney.dto.MovieFiltersDTO;
import com.facu.disney.entity.Genre;
import com.facu.disney.entity.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
public class MovieSpecification {

    public Specification<Movie> getMovieByFilters(MovieFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getTitle())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                "%" + filtersDTO.getTitle().toLowerCase() + "%"));
            }

            if (!CollectionUtils.isEmpty(filtersDTO.getGenre())) {
                Join<Genre, Movie> join = root.join("genre", JoinType.INNER);
                Expression<String> genreId = join.get("idGenre");
                predicates.add(genreId.in(filtersDTO.getGenre()));
            }

            //remove duplicates
            query.distinct(true);

            //order resolver
            String orderByField = "creationDate";
            query.orderBy(
                    filtersDTO.isASC()
                    ? criteriaBuilder.asc(root.get(orderByField))
                    : criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
